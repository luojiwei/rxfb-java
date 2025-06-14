package com.ruoyi.website.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Banner信息对象 website_banner
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
public class WebsiteBanner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** BannerID */
    private Long bannerId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imageUrl;

    /** 跳转类型（0=无关联 1=产品 2=新闻 3=外链） */
    @Excel(name = "跳转类型", readConverterExp = "0==无关联,1==产品,2==新闻,3==外链")
    private String linkType;

    /** 关联ID（产品/新闻ID） */
    private Long refId;

    /** 外部链接地址 */
    private String linkUrl;

    /** 显示位置(home-首页,product-产品页,news-新闻页) */
    @Excel(name = "显示位置(home-首页,product-产品页,news-新闻页)")
    private String position;

    /** 显示顺序 */
    private Long sort;

    /** 状态（0=正常 1=停用） */
    @Excel(name = "状态", readConverterExp = "0==正常,1==停用")
    private String status;

    public void setBannerId(Long bannerId) 
    {
        this.bannerId = bannerId;
    }

    public Long getBannerId() 
    {
        return bannerId;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    public void setLinkType(String linkType) 
    {
        this.linkType = linkType;
    }

    public String getLinkType() 
    {
        return linkType;
    }

    public void setRefId(Long refId) 
    {
        this.refId = refId;
    }

    public Long getRefId() 
    {
        return refId;
    }

    public void setLinkUrl(String linkUrl) 
    {
        this.linkUrl = linkUrl;
    }

    public String getLinkUrl() 
    {
        return linkUrl;
    }

    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }

    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bannerId", getBannerId())
            .append("title", getTitle())
            .append("imageUrl", getImageUrl())
            .append("linkType", getLinkType())
            .append("refId", getRefId())
            .append("linkUrl", getLinkUrl())
            .append("position", getPosition())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
