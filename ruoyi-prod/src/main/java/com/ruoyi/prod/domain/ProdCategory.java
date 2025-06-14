package com.ruoyi.prod.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 产品分类对象 prod_category
 * 
 * @author luojiwei
 * @date 2025-06-11
 */
public class ProdCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分类ID */
    private Long categoryId;

    /** 父分类ID(0=根分类) */
    @Excel(name = "父分类ID(0=根分类)")
    private Long parentId;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String categoryName;

    /** 封面 */
    @Excel(name = "封面")
    private String cover;

    /** 祖级列表(逗号分隔) */
    @Excel(name = "祖级列表(逗号分隔)")
    private String ancestors;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long orderNum;

    /** 状态(0正常 1停用) */
    @Excel(name = "状态(0正常 1停用)")
    private String status;

    /** 删除标志(0存在 1删除) */
    private String delFlag;

    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }

    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }

    public void setCategoryName(String categoryName) 
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName() 
    {
        return categoryName;
    }

    public String getCover() { return cover; }

    public void setCover(String cover) { this.cover = cover; }

    public void setAncestors(String ancestors) 
    {
        this.ancestors = ancestors;
    }

    public String getAncestors() 
    {
        return ancestors;
    }

    public void setOrderNum(Long orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() 
    {
        return orderNum;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("categoryId", getCategoryId())
            .append("parentId", getParentId())
            .append("categoryName", getCategoryName())
            .append("cover", getCover())
            .append("ancestors", getAncestors())
            .append("orderNum", getOrderNum())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
