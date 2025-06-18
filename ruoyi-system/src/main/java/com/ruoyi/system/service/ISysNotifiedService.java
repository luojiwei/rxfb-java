package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysNotified;

/**
 * 通知信息Service接口
 * 
 * @author luojiwei
 * @date 2025-06-17
 */
public interface ISysNotifiedService 
{
    /**
     * 查询通知信息
     * 
     * @param notifiedId 通知信息主键
     * @return 通知信息
     */
    public SysNotified selectSysNotifiedByNotifiedId(Long notifiedId);

    /**
     * 查询通知信息列表
     * 
     * @param sysNotified 通知信息
     * @return 通知信息集合
     */
    public List<SysNotified> selectSysNotifiedList(SysNotified sysNotified);

    /**
     * 新增通知信息
     * 
     * @param sysNotified 通知信息
     * @return 结果
     */
    public int insertSysNotified(SysNotified sysNotified);

    /**
     * 修改通知信息
     * 
     * @param sysNotified 通知信息
     * @return 结果
     */
    public int updateSysNotified(SysNotified sysNotified);

    /**
     * 批量删除通知信息
     * 
     * @param notifiedIds 需要删除的通知信息主键集合
     * @return 结果
     */
    public int deleteSysNotifiedByNotifiedIds(Long[] notifiedIds);

    /**
     * 批量修改已读状态
     *
     * @param sysNotified 需要修改的通知信息主键集合
     * @return 结果
     */
    int batchReviseByNotifiedIds(SysNotified sysNotified);
}
