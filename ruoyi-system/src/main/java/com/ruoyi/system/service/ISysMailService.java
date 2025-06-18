package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysMail;

/**
 * 邮件信息Service接口
 * 
 * @author luojiwei
 * @date 2025-06-15
 */
public interface ISysMailService 
{
    /**
     * 查询邮件信息
     * 
     * @param id 邮件信息主键
     * @return 邮件信息
     */
    public SysMail selectSysMailById(Long id);

    /**
     * 查询邮件信息列表
     * 
     * @param sysMail 邮件信息
     * @return 邮件信息集合
     */
    public List<SysMail> selectSysMailList(SysMail sysMail);

    /**
     * 新增邮件信息
     * 
     * @param sysMail 邮件信息
     * @return 结果
     */
    public int insertSysMail(SysMail sysMail);


    /**
     * 删除邮件信息信息
     * 
     * @param id 邮件信息主键
     * @return 结果
     */
    public int deleteSysMailById(Long id);

    /**
     * 查询用户发送的邮件列表
     *
     * @param userId 用户id
     * @return 邮件信息集合
     */
    List<SysMail> selectSentMailsByUserId(Long userId);

    /**
     * 查询用户接收的邮件列表
     *
     * @param userId 用户id
     * @return 邮件信息集合
     */
    List<SysMail> selectReceivedMailsByUserId(Long userId);
}
