package com.ruoyi.website.service;

import java.util.List;
import com.ruoyi.website.domain.WebsitePartner;

/**
 * 伙伴信息Service接口
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
public interface IWebsitePartnerService 
{
    /**
     * 查询伙伴信息
     * 
     * @param partnerId 伙伴信息主键
     * @return 伙伴信息
     */
    public WebsitePartner selectWebsitePartnerByPartnerId(Long partnerId);

    /**
     * 查询伙伴信息列表
     * 
     * @param websitePartner 伙伴信息
     * @return 伙伴信息集合
     */
    public List<WebsitePartner> selectWebsitePartnerList(WebsitePartner websitePartner);

    /**
     * 新增伙伴信息
     * 
     * @param websitePartner 伙伴信息
     * @return 结果
     */
    public int insertWebsitePartner(WebsitePartner websitePartner);

    /**
     * 修改伙伴信息
     * 
     * @param websitePartner 伙伴信息
     * @return 结果
     */
    public int updateWebsitePartner(WebsitePartner websitePartner);

    /**
     * 批量删除伙伴信息
     * 
     * @param partnerIds 需要删除的伙伴信息主键集合
     * @return 结果
     */
    public int deleteWebsitePartnerByPartnerIds(Long[] partnerIds);

    /**
     * 删除伙伴信息信息
     * 
     * @param partnerId 伙伴信息主键
     * @return 结果
     */
    public int deleteWebsitePartnerByPartnerId(Long partnerId);
}
