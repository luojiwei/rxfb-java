package com.ruoyi.website.mapper;

import java.util.List;
import com.ruoyi.website.domain.WebsiteBanner;

/**
 * Banner信息Mapper接口
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
public interface WebsiteBannerMapper 
{
    /**
     * 查询Banner信息
     * 
     * @param bannerId Banner信息主键
     * @return Banner信息
     */
    public WebsiteBanner selectWebsiteBannerByBannerId(Long bannerId);

    /**
     * 查询Banner信息列表
     * 
     * @param websiteBanner Banner信息
     * @return Banner信息集合
     */
    public List<WebsiteBanner> selectWebsiteBannerList(WebsiteBanner websiteBanner);

    /**
     * 新增Banner信息
     * 
     * @param websiteBanner Banner信息
     * @return 结果
     */
    public int insertWebsiteBanner(WebsiteBanner websiteBanner);

    /**
     * 修改Banner信息
     * 
     * @param websiteBanner Banner信息
     * @return 结果
     */
    public int updateWebsiteBanner(WebsiteBanner websiteBanner);

    /**
     * 删除Banner信息
     * 
     * @param bannerId Banner信息主键
     * @return 结果
     */
    public int deleteWebsiteBannerByBannerId(Long bannerId);

    /**
     * 批量删除Banner信息
     * 
     * @param bannerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWebsiteBannerByBannerIds(Long[] bannerIds);
}
