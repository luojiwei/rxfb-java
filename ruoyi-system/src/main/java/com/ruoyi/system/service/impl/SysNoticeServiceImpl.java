package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.constant.NotifiedConstants;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.SysNotified;
import com.ruoyi.system.service.ISysNotifiedService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.mapper.SysNoticeMapper;
import com.ruoyi.system.service.ISysNoticeService;
import org.springframework.util.CollectionUtils;

/**
 * 公告 服务层实现
 * 
 * @author ruoyi
 */
@Service
public class SysNoticeServiceImpl implements ISysNoticeService
{
    @Autowired
    private SysNoticeMapper noticeMapper;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysNotifiedService notifiedService;

    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    @Override
    public SysNotice selectNoticeById(Long noticeId)
    {
        return noticeMapper.selectNoticeById(noticeId);
    }

    /**
     * 查询公告列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    @Override
    public List<SysNotice> selectNoticeList(SysNotice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int insertNotice(SysNotice notice)
    {
        int rows = noticeMapper.insertNotice(notice);
        sendNotified(notice);
        return rows;
    }

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int updateNotice(SysNotice notice)
    {
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 删除公告对象
     * 
     * @param noticeId 公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeById(Long noticeId)
    {
        return noticeMapper.deleteNoticeById(noticeId);
    }

    /**
     * 批量删除公告信息
     * 
     * @param noticeIds 需要删除的公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(Long[] noticeIds)
    {
        return noticeMapper.deleteNoticeByIds(noticeIds);
    }

    /**
     * 批量发送通知
     *
     * @param notice
     */
    private void sendNotified(SysNotice notice) {
        SysUser user = new SysUser();
        List<SysUser> userList = userService.selectUserList(user);
        if (!CollectionUtils.isEmpty(userList)) {
            for (SysUser sysUser : userList) {
                SysNotified sysNotified = new SysNotified();
                sysNotified.setNotifiedType(NotifiedConstants.NOTICE_TYPE);
                sysNotified.setUserId(sysUser.getUserId());
                sysNotified.setContent(notice.getNoticeTitle());
                sysNotified.setRefId(notice.getNoticeId());
                notifiedService.insertSysNotified(sysNotified);
            }
        }
    }
}
