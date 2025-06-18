package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysNotifiedMapper;
import com.ruoyi.system.domain.SysNotified;
import com.ruoyi.system.service.ISysNotifiedService;

/**
 * 通知信息Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-17
 */
@Service
public class SysNotifiedServiceImpl implements ISysNotifiedService 
{
    @Autowired
    private SysNotifiedMapper sysNotifiedMapper;

    /**
     * 查询通知信息
     * 
     * @param notifiedId 通知信息主键
     * @return 通知信息
     */
    @Override
    public SysNotified selectSysNotifiedByNotifiedId(Long notifiedId)
    {
        return sysNotifiedMapper.selectSysNotifiedByNotifiedId(notifiedId);
    }

    /**
     * 查询通知信息列表
     * 
     * @param sysNotified 通知信息
     * @return 通知信息
     */
    @Override
    public List<SysNotified> selectSysNotifiedList(SysNotified sysNotified)
    {
        return sysNotifiedMapper.selectSysNotifiedList(sysNotified);
    }

    /**
     * 新增通知信息
     * 
     * @param sysNotified 通知信息
     * @return 结果
     */
    @Override
    public int insertSysNotified(SysNotified sysNotified)
    {
        sysNotified.setCreateTime(DateUtils.getNowDate());
        return sysNotifiedMapper.insertSysNotified(sysNotified);
    }

    /**
     * 修改通知信息
     * 
     * @param sysNotified 通知信息
     * @return 结果
     */
    @Override
    public int updateSysNotified(SysNotified sysNotified)
    {
        return sysNotifiedMapper.updateSysNotified(sysNotified);
    }

    /**
     * 批量删除通知信息
     * 
     * @param notifiedIds 需要删除的通知信息主键
     * @return 结果
     */
    @Override
    public int deleteSysNotifiedByNotifiedIds(Long[] notifiedIds)
    {
        return sysNotifiedMapper.deleteSysNotifiedByNotifiedIds(notifiedIds);
    }

    /**
     * 批量修改已读状态
     *
     * @param sysNotified 需要修改的通知信息主键集合
     * @return 结果
     */
    @Override
    public int batchReviseByNotifiedIds(SysNotified sysNotified)
    {
        return sysNotifiedMapper.batchReviseByNotifiedIds(sysNotified);
    }
}
