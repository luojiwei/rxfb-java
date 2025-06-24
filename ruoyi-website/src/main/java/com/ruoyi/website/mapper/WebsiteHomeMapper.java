package com.ruoyi.website.mapper;

import com.ruoyi.website.domain.WebsiteHome;

/**
 * 官网信息Mapper接口
 * 
 * @author luojiwei
 * @date 2025-06-19
 */
public interface WebsiteHomeMapper
{
    WebsiteHome selectWebsiteHomeById(Long id);
    
    int updateWebsiteHome(WebsiteHome websiteHome);
}
