package com.ruoyi.website.mapper;

import java.util.List;
import com.ruoyi.website.domain.WebsiteNews;

/**
 * 新闻信息Mapper接口
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
public interface WebsiteNewsMapper 
{
    /**
     * 查询新闻信息
     * 
     * @param newsId 新闻信息主键
     * @return 新闻信息
     */
    public WebsiteNews selectWebsiteNewsByNewsId(Long newsId);

    /**
     * 查询新闻信息列表
     * 
     * @param websiteNews 新闻信息
     * @return 新闻信息集合
     */
    public List<WebsiteNews> selectWebsiteNewsList(WebsiteNews websiteNews);

    /**
     * 搜索新闻信息列表
     *
     * @param websiteNews 新闻信息
     * @return 新闻信息集合
     */
    public List<WebsiteNews> searchNewsList(WebsiteNews websiteNews);

    /**
     * 新增新闻信息
     * 
     * @param websiteNews 新闻信息
     * @return 结果
     */
    public int insertWebsiteNews(WebsiteNews websiteNews);

    /**
     * 修改新闻信息
     * 
     * @param websiteNews 新闻信息
     * @return 结果
     */
    public int updateWebsiteNews(WebsiteNews websiteNews);

    /**
     * 删除新闻信息
     * 
     * @param newsId 新闻信息主键
     * @return 结果
     */
    public int deleteWebsiteNewsByNewsId(Long newsId);

    /**
     * 批量删除新闻信息
     * 
     * @param newsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWebsiteNewsByNewsIds(Long[] newsIds);
}
