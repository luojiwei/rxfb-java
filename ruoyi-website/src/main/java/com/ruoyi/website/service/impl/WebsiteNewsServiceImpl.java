package com.ruoyi.website.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.website.mapper.WebsiteNewsMapper;
import com.ruoyi.website.domain.WebsiteNews;
import com.ruoyi.website.service.IWebsiteNewsService;

/**
 * 新闻信息Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@Service
public class WebsiteNewsServiceImpl implements IWebsiteNewsService 
{
    @Autowired
    private WebsiteNewsMapper websiteNewsMapper;

    /**
     * 查询新闻信息
     * 
     * @param newsId 新闻信息主键
     * @return 新闻信息
     */
    @Override
    public WebsiteNews selectWebsiteNewsByNewsId(Long newsId)
    {
        return websiteNewsMapper.selectWebsiteNewsByNewsId(newsId);
    }

    /**
     * 查询新闻信息列表
     * 
     * @param websiteNews 新闻信息
     * @return 新闻信息
     */
    @Override
    public List<WebsiteNews> selectWebsiteNewsList(WebsiteNews websiteNews)
    {
        return websiteNewsMapper.selectWebsiteNewsList(websiteNews);
    }

    /**
     * 搜索新闻信息列表
     *
     * @param websiteNews 新闻信息
     * @return 新闻信息
     */
    @Override
    public List<WebsiteNews> searchNewsList(WebsiteNews websiteNews)
    {
        return websiteNewsMapper.searchNewsList(websiteNews);
    }

    /**
     * 新增新闻信息
     * 
     * @param websiteNews 新闻信息
     * @return 结果
     */
    @Override
    public int insertWebsiteNews(WebsiteNews websiteNews)
    {
        websiteNews.setCreateBy(SecurityUtils.getUsername());
        websiteNews.setCreateTime(DateUtils.getNowDate());
        return websiteNewsMapper.insertWebsiteNews(websiteNews);
    }

    /**
     * 修改新闻信息
     * 
     * @param websiteNews 新闻信息
     * @return 结果
     */
    @Override
    public int updateWebsiteNews(WebsiteNews websiteNews)
    {
        websiteNews.setUpdateBy(SecurityUtils.getUsername());
        websiteNews.setUpdateTime(DateUtils.getNowDate());
        return websiteNewsMapper.updateWebsiteNews(websiteNews);
    }

    /**
     * 批量删除新闻信息
     * 
     * @param newsIds 需要删除的新闻信息主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteNewsByNewsIds(Long[] newsIds)
    {
        return websiteNewsMapper.deleteWebsiteNewsByNewsIds(newsIds);
    }

    /**
     * 删除新闻信息信息
     * 
     * @param newsId 新闻信息主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteNewsByNewsId(Long newsId)
    {
        return websiteNewsMapper.deleteWebsiteNewsByNewsId(newsId);
    }
}
