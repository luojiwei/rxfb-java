package com.ruoyi.website.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.website.mapper.WebsiteHonorMapper;
import com.ruoyi.website.domain.WebsiteHonor;
import com.ruoyi.website.service.IWebsiteHonorService;

/**
 * 荣誉信息Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@Service
public class WebsiteHonorServiceImpl implements IWebsiteHonorService 
{
    @Autowired
    private WebsiteHonorMapper websiteHonorMapper;

    /**
     * 查询荣誉信息
     * 
     * @param honorId 荣誉信息主键
     * @return 荣誉信息
     */
    @Override
    public WebsiteHonor selectWebsiteHonorByHonorId(Long honorId)
    {
        return websiteHonorMapper.selectWebsiteHonorByHonorId(honorId);
    }

    /**
     * 查询荣誉信息列表
     * 
     * @param websiteHonor 荣誉信息
     * @return 荣誉信息
     */
    @Override
    public List<WebsiteHonor> selectWebsiteHonorList(WebsiteHonor websiteHonor)
    {
        return websiteHonorMapper.selectWebsiteHonorList(websiteHonor);
    }

    /**
     * 新增荣誉信息
     * 
     * @param websiteHonor 荣誉信息
     * @return 结果
     */
    @Override
    public int insertWebsiteHonor(WebsiteHonor websiteHonor)
    {
        websiteHonor.setCreateBy(SecurityUtils.getUsername());
        websiteHonor.setCreateTime(DateUtils.getNowDate());
        return websiteHonorMapper.insertWebsiteHonor(websiteHonor);
    }

    /**
     * 修改荣誉信息
     * 
     * @param websiteHonor 荣誉信息
     * @return 结果
     */
    @Override
    public int updateWebsiteHonor(WebsiteHonor websiteHonor)
    {
        websiteHonor.setUpdateBy(SecurityUtils.getUsername());
        websiteHonor.setUpdateTime(DateUtils.getNowDate());
        return websiteHonorMapper.updateWebsiteHonor(websiteHonor);
    }

    /**
     * 批量删除荣誉信息
     * 
     * @param honorIds 需要删除的荣誉信息主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteHonorByHonorIds(Long[] honorIds)
    {
        return websiteHonorMapper.deleteWebsiteHonorByHonorIds(honorIds);
    }

    /**
     * 删除荣誉信息信息
     * 
     * @param honorId 荣誉信息主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteHonorByHonorId(Long honorId)
    {
        return websiteHonorMapper.deleteWebsiteHonorByHonorId(honorId);
    }
}
