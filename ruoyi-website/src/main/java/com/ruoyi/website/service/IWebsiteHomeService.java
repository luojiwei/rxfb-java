package com.ruoyi.website.service;

import com.ruoyi.website.domain.WebsiteHome;

/**
 * 官网信息Service接口
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
public interface IWebsiteHomeService 
{
    /**
     * 查询官网信息
     * 
     * @param id 官网信息主键
     * @return 官网信息
     */
    WebsiteHome selectWebsiteHomeById(Long id);

    /**
     * 修改官网信息
     * 
     * @param websiteHome 官网信息
     * @return 结果
     */
    int updateWebsiteHome(WebsiteHome websiteHome);
}
