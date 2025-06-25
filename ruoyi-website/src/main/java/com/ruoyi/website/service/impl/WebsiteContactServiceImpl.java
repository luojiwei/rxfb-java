package com.ruoyi.website.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.website.mapper.WebsiteContactMapper;
import com.ruoyi.website.domain.WebsiteContact;
import com.ruoyi.website.service.IWebsiteContactService;

/**
 * 官网留言Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-25
 */
@Service
public class WebsiteContactServiceImpl implements IWebsiteContactService 
{
    @Autowired
    private WebsiteContactMapper websiteContactMapper;

    /**
     * 查询官网留言
     * 
     * @param contactId 官网留言主键
     * @return 官网留言
     */
    @Override
    public WebsiteContact selectWebsiteContactByContactId(Long contactId)
    {
        return websiteContactMapper.selectWebsiteContactByContactId(contactId);
    }

    /**
     * 查询官网留言列表
     * 
     * @param websiteContact 官网留言
     * @return 官网留言
     */
    @Override
    public List<WebsiteContact> selectWebsiteContactList(WebsiteContact websiteContact)
    {
        return websiteContactMapper.selectWebsiteContactList(websiteContact);
    }

    /**
     * 新增官网留言
     * 
     * @param websiteContact 官网留言
     * @return 结果
     */
    @Override
    public int insertWebsiteContact(WebsiteContact websiteContact)
    {
        websiteContact.setCreateTime(DateUtils.getNowDate());
        return websiteContactMapper.insertWebsiteContact(websiteContact);
    }

    /**
     * 修改官网留言
     * 
     * @param websiteContact 官网留言
     * @return 结果
     */
    @Override
    public int updateWebsiteContact(WebsiteContact websiteContact)
    {
        return websiteContactMapper.updateWebsiteContact(websiteContact);
    }

    /**
     * 批量删除官网留言
     * 
     * @param contactIds 需要删除的官网留言主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteContactByContactIds(Long[] contactIds)
    {
        return websiteContactMapper.deleteWebsiteContactByContactIds(contactIds);
    }

    /**
     * 删除官网留言信息
     * 
     * @param contactId 官网留言主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteContactByContactId(Long contactId)
    {
        return websiteContactMapper.deleteWebsiteContactByContactId(contactId);
    }
}
