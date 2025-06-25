package com.ruoyi.website.mapper;

import java.util.List;
import com.ruoyi.website.domain.WebsiteContact;

/**
 * 官网留言Mapper接口
 * 
 * @author luojiwei
 * @date 2025-06-25
 */
public interface WebsiteContactMapper 
{
    /**
     * 查询官网留言
     * 
     * @param contactId 官网留言主键
     * @return 官网留言
     */
    public WebsiteContact selectWebsiteContactByContactId(Long contactId);

    /**
     * 查询官网留言列表
     * 
     * @param websiteContact 官网留言
     * @return 官网留言集合
     */
    public List<WebsiteContact> selectWebsiteContactList(WebsiteContact websiteContact);

    /**
     * 新增官网留言
     * 
     * @param websiteContact 官网留言
     * @return 结果
     */
    public int insertWebsiteContact(WebsiteContact websiteContact);

    /**
     * 修改官网留言
     * 
     * @param websiteContact 官网留言
     * @return 结果
     */
    public int updateWebsiteContact(WebsiteContact websiteContact);

    /**
     * 删除官网留言
     * 
     * @param contactId 官网留言主键
     * @return 结果
     */
    public int deleteWebsiteContactByContactId(Long contactId);

    /**
     * 批量删除官网留言
     * 
     * @param contactIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWebsiteContactByContactIds(Long[] contactIds);
}
