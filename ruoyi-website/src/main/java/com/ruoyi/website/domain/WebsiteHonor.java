package com.ruoyi.website.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 荣誉信息对象 website_honor
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
public class WebsiteHonor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 荣誉ID */
    private Long honorId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imageUrl;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long sort;

    /** 状态（0=正常 1=停用） */
    @Excel(name = "状态", readConverterExp = "0==正常,1==停用")
    private String status;

    public void setHonorId(Long honorId) 
    {
        this.honorId = honorId;
    }

    public Long getHonorId() 
    {
        return honorId;
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
            .append("honorId", getHonorId())
            .append("title", getTitle())
            .append("imageUrl", getImageUrl())
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
