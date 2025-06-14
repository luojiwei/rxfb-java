package com.ruoyi.website.service;

import java.util.List;
import com.ruoyi.website.domain.WebsiteHonor;

/**
 * 荣誉信息Service接口
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
public interface IWebsiteHonorService 
{
    /**
     * 查询荣誉信息
     * 
     * @param honorId 荣誉信息主键
     * @return 荣誉信息
     */
    public WebsiteHonor selectWebsiteHonorByHonorId(Long honorId);

    /**
     * 查询荣誉信息列表
     * 
     * @param websiteHonor 荣誉信息
     * @return 荣誉信息集合
     */
    public List<WebsiteHonor> selectWebsiteHonorList(WebsiteHonor websiteHonor);

    /**
     * 新增荣誉信息
     * 
     * @param websiteHonor 荣誉信息
     * @return 结果
     */
    public int insertWebsiteHonor(WebsiteHonor websiteHonor);

    /**
     * 修改荣誉信息
     * 
     * @param websiteHonor 荣誉信息
     * @return 结果
     */
    public int updateWebsiteHonor(WebsiteHonor websiteHonor);

    /**
     * 批量删除荣誉信息
     * 
     * @param honorIds 需要删除的荣誉信息主键集合
     * @return 结果
     */
    public int deleteWebsiteHonorByHonorIds(Long[] honorIds);

    /**
     * 删除荣誉信息信息
     * 
     * @param honorId 荣誉信息主键
     * @return 结果
     */
    public int deleteWebsiteHonorByHonorId(Long honorId);
}
