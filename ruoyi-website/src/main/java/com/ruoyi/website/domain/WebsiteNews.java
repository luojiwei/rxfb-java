package com.ruoyi.website.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 新闻信息对象 website_news
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
public class WebsiteNews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 新闻ID */
    private Long newsId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 概要描述 */
    private String newsDesc;

    /** 封面图片 */
    @Excel(name = "封面图片")
    private String cover;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 新闻类型 */
    @Excel(name = "新闻类型(0=公司新闻 1=行业新闻)")
    private String newsType;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long pageView;

    /** 是否置顶(0=否 1=是) */
    @Excel(name = "是否置顶(0=否 1=是)")
    private String isTop;

    /** 是否推荐(0=否 1=是) */
    @Excel(name = "是否推荐(0=否 1=是)")
    private String isRmd;

    /** 标签 */
    @Excel(name = "标签")
    private String tags;

    /** 新闻内容 */
    private String content;

    /** 状态（0=正常 1=停用） */
    @Excel(name = "状态", readConverterExp = "0==正常,1==停用")
    private String status;

    /** 搜索关键词 */
    private String keyword;

    public void setNewsId(Long newsId) 
    {
        this.newsId = newsId;
    }

    public Long getNewsId() 
    {
        return newsId;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setCover(String cover) 
    {
        this.cover = cover;
    }

    public String getCover() 
    {
        return cover;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }

    public String getNewsDesc() { return newsDesc; }

    public void setNewsDesc(String newsDesc) { this.newsDesc = newsDesc; }

    public void setReleaseTime(Date releaseTime) 
    {
        this.releaseTime = releaseTime;
    }

    public Date getReleaseTime() 
    {
        return releaseTime;
    }

    public void setPageView(Long pageView) 
    {
        this.pageView = pageView;
    }

    public Long getPageView() 
    {
        return pageView;
    }

    public void setIsTop(String isTop)
    {
        this.isTop = isTop;
    }

    public String getIsTop()
    {
        return isTop;
    }

    public void setIsRmd(String isRmd)
    {
        this.isRmd = isRmd;
    }

    public String getIsRmd()
    {
        return isRmd;
    }

    public void setTags(String tags) 
    {
        this.tags = tags;
    }

    public String getTags() 
    {
        return tags;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public String getKeyword()
    {
        return keyword;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("newsId", getNewsId())
            .append("title", getTitle())
            .append("newsDesc", getNewsDesc())
            .append("cover", getCover())
            .append("author", getAuthor())
            .append("newsType", getNewsType())
            .append("releaseTime", getReleaseTime())
            .append("pageView", getPageView())
            .append("isTop", getIsTop())
            .append("isRmd", getIsRmd())
            .append("tags", getTags())
            .append("content", getContent())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("keyword", getKeyword())
            .toString();
    }
}
