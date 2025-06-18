package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.constant.NotifiedConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.SysNotified;
import com.ruoyi.system.service.ISysNotifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.SysMailReceiver;
import com.ruoyi.system.mapper.SysMailMapper;
import com.ruoyi.system.domain.SysMail;
import com.ruoyi.system.service.ISysMailService;

/**
 * 邮件信息Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-15
 */
@Service
public class SysMailServiceImpl implements ISysMailService 
{
    @Autowired
    private SysMailMapper sysMailMapper;

    @Autowired
    private ISysNotifiedService notifiedService;

    /**
     * 查询邮件信息
     * 
     * @param id 邮件信息主键
     * @return 邮件信息
     */
    @Override
    public SysMail selectSysMailById(Long id)
    {
        return sysMailMapper.selectSysMailById(id);
    }

    /**
     * 查询邮件信息列表
     * 
     * @param sysMail 邮件信息
     * @return 邮件信息
     */
    @Override
    public List<SysMail> selectSysMailList(SysMail sysMail)
    {
        return sysMailMapper.selectSysMailList(sysMail);
    }

    /**
     * 新增邮件信息
     * 
     * @param sysMail 邮件信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSysMail(SysMail sysMail)
    {
        sysMail.setSenderId(SecurityUtils.getUserId());
        sysMail.setSenderName(SecurityUtils.getUsername());
        sysMail.setSendTime(DateUtils.getNowDate());
        int rows = sysMailMapper.insertSysMail(sysMail);
        insertSysMailReceiver(sysMail);
        return rows;
    }

    /**
     * 删除邮件信息信息
     * 
     * @param id 邮件信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysMailById(Long id)
    {
        sysMailMapper.deleteSysMailReceiverByMailId(id);
        return sysMailMapper.deleteSysMailById(id);
    }

    /**
     * 查询用户发送的邮件列表
     *
     * @param userId 用户id
     * @return 邮件信息集合
     */
    @Override
    public List<SysMail> selectSentMailsByUserId(Long userId)
    {
        return sysMailMapper.selectSentMailsByUserId(userId);
    }

    /**
     * 查询用户接收的邮件列表
     *
     * @param userId 用户id
     * @return 邮件信息集合
     */
    @Override
    public List<SysMail> selectReceivedMailsByUserId(Long userId)
    {
        return sysMailMapper.selectReceivedMailsByUserId(userId);
    }

    /**
     * 新增邮件接收人信息
     * 
     * @param sysMail 邮件信息对象
     */
    public void insertSysMailReceiver(SysMail sysMail)
    {
        List<SysMailReceiver> sysMailReceiverList = sysMail.getSysMailReceiverList();
        Long id = sysMail.getId();
        if (StringUtils.isNotNull(sysMailReceiverList))
        {
            List<SysMailReceiver> list = new ArrayList<SysMailReceiver>();
            for (SysMailReceiver sysMailReceiver : sysMailReceiverList)
            {
                sysMailReceiver.setMailId(id);
                list.add(sysMailReceiver);
                sendNotified(sysMail, sysMailReceiver);
            }
            if (list.size() > 0)
            {
                sysMailMapper.batchSysMailReceiver(list);
            }
        }
    }

    /**
     * 发送通知
     *
     * @param sysMail
     */
    private void sendNotified(SysMail sysMail, SysMailReceiver sysMailReceiver) {
        SysNotified sysNotified = new SysNotified();
        sysNotified.setNotifiedType(NotifiedConstants.MAIL_TYPE);
        sysNotified.setUserId(sysMailReceiver.getUserId());
        sysNotified.setContent(sysMail.getSubject());
        sysNotified.setRefId(sysMail.getId());
        notifiedService.insertSysNotified(sysNotified);
    }
}
