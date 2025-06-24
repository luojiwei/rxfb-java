package com.ruoyi.website.service.impl;

import com.ruoyi.website.domain.WebsiteHome;
import com.ruoyi.website.mapper.WebsiteHomeMapper;
import com.ruoyi.website.service.IWebsiteHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 官网信息Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@Service
public class WebsiteHomeServiceImpl implements IWebsiteHomeService 
{
    @Autowired
    private WebsiteHomeMapper websiteHomeMapper;

    /**
     * 查询官网信息
     * 
     * @param id 官网信息主键
     * @return 官网信息
     */
    @Override
    public WebsiteHome selectWebsiteHomeById(Long id)
    {
        return websiteHomeMapper.selectWebsiteHomeById(id);
    }

    /**
     * 修改官网信息
     * 
     * @param websiteHome 官网信息
     * @return 结果
     */
    @Override
    public int updateWebsiteHome(WebsiteHome websiteHome)
    {
        return websiteHomeMapper.updateWebsiteHome(websiteHome);
    }
}
