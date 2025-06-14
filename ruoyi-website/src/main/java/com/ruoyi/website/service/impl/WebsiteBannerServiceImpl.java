package com.ruoyi.website.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.website.mapper.WebsiteBannerMapper;
import com.ruoyi.website.domain.WebsiteBanner;
import com.ruoyi.website.service.IWebsiteBannerService;

/**
 * Banner信息Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@Service
public class WebsiteBannerServiceImpl implements IWebsiteBannerService 
{
    @Autowired
    private WebsiteBannerMapper websiteBannerMapper;

    /**
     * 查询Banner信息
     * 
     * @param bannerId Banner信息主键
     * @return Banner信息
     */
    @Override
    public WebsiteBanner selectWebsiteBannerByBannerId(Long bannerId)
    {
        return websiteBannerMapper.selectWebsiteBannerByBannerId(bannerId);
    }

    /**
     * 查询Banner信息列表
     * 
     * @param websiteBanner Banner信息
     * @return Banner信息
     */
    @Override
    public List<WebsiteBanner> selectWebsiteBannerList(WebsiteBanner websiteBanner)
    {
        return websiteBannerMapper.selectWebsiteBannerList(websiteBanner);
    }

    /**
     * 新增Banner信息
     * 
     * @param websiteBanner Banner信息
     * @return 结果
     */
    @Override
    public int insertWebsiteBanner(WebsiteBanner websiteBanner)
    {
        websiteBanner.setCreateBy(SecurityUtils.getUsername());
        websiteBanner.setCreateTime(DateUtils.getNowDate());
        return websiteBannerMapper.insertWebsiteBanner(websiteBanner);
    }

    /**
     * 修改Banner信息
     * 
     * @param websiteBanner Banner信息
     * @return 结果
     */
    @Override
    public int updateWebsiteBanner(WebsiteBanner websiteBanner)
    {
        websiteBanner.setUpdateBy(SecurityUtils.getUsername());
        websiteBanner.setUpdateTime(DateUtils.getNowDate());
        return websiteBannerMapper.updateWebsiteBanner(websiteBanner);
    }

    /**
     * 批量删除Banner信息
     * 
     * @param bannerIds 需要删除的Banner信息主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteBannerByBannerIds(Long[] bannerIds)
    {
        return websiteBannerMapper.deleteWebsiteBannerByBannerIds(bannerIds);
    }

    /**
     * 删除Banner信息信息
     * 
     * @param bannerId Banner信息主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteBannerByBannerId(Long bannerId)
    {
        return websiteBannerMapper.deleteWebsiteBannerByBannerId(bannerId);
    }
}
