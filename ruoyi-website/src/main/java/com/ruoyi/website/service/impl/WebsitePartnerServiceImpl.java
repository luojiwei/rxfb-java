package com.ruoyi.website.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.website.mapper.WebsitePartnerMapper;
import com.ruoyi.website.domain.WebsitePartner;
import com.ruoyi.website.service.IWebsitePartnerService;

/**
 * 伙伴信息Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@Service
public class WebsitePartnerServiceImpl implements IWebsitePartnerService 
{
    @Autowired
    private WebsitePartnerMapper websitePartnerMapper;

    /**
     * 查询伙伴信息
     * 
     * @param partnerId 伙伴信息主键
     * @return 伙伴信息
     */
    @Override
    public WebsitePartner selectWebsitePartnerByPartnerId(Long partnerId)
    {
        return websitePartnerMapper.selectWebsitePartnerByPartnerId(partnerId);
    }

    /**
     * 查询伙伴信息列表
     * 
     * @param websitePartner 伙伴信息
     * @return 伙伴信息
     */
    @Override
    public List<WebsitePartner> selectWebsitePartnerList(WebsitePartner websitePartner)
    {
        return websitePartnerMapper.selectWebsitePartnerList(websitePartner);
    }

    /**
     * 新增伙伴信息
     * 
     * @param websitePartner 伙伴信息
     * @return 结果
     */
    @Override
    public int insertWebsitePartner(WebsitePartner websitePartner)
    {
        websitePartner.setCreateBy(SecurityUtils.getUsername());
        websitePartner.setCreateTime(DateUtils.getNowDate());
        return websitePartnerMapper.insertWebsitePartner(websitePartner);
    }

    /**
     * 修改伙伴信息
     * 
     * @param websitePartner 伙伴信息
     * @return 结果
     */
    @Override
    public int updateWebsitePartner(WebsitePartner websitePartner)
    {
        websitePartner.setUpdateBy(SecurityUtils.getUsername());
        websitePartner.setUpdateTime(DateUtils.getNowDate());
        return websitePartnerMapper.updateWebsitePartner(websitePartner);
    }

    /**
     * 批量删除伙伴信息
     * 
     * @param partnerIds 需要删除的伙伴信息主键
     * @return 结果
     */
    @Override
    public int deleteWebsitePartnerByPartnerIds(Long[] partnerIds)
    {
        return websitePartnerMapper.deleteWebsitePartnerByPartnerIds(partnerIds);
    }

    /**
     * 删除伙伴信息信息
     * 
     * @param partnerId 伙伴信息主键
     * @return 结果
     */
    @Override
    public int deleteWebsitePartnerByPartnerId(Long partnerId)
    {
        return websitePartnerMapper.deleteWebsitePartnerByPartnerId(partnerId);
    }
}
