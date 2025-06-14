package com.ruoyi.website.mapper;

import java.util.List;
import com.ruoyi.website.domain.WebsitePartner;

/**
 * 伙伴信息Mapper接口
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
public interface WebsitePartnerMapper 
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
     * 删除伙伴信息
     * 
     * @param partnerId 伙伴信息主键
     * @return 结果
     */
    public int deleteWebsitePartnerByPartnerId(Long partnerId);

    /**
     * 批量删除伙伴信息
     * 
     * @param partnerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWebsitePartnerByPartnerIds(Long[] partnerIds);
}
