package com.ruoyi.website.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品展示对象 website_product
 * 
 * @author luojiwei
 * @date 2025-06-24
 */
public class WebsiteProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long productId;

    /** 展示位置（0=首页） */
    @Excel(name = "展示位置", readConverterExp = "0==首页")
    private String position;

    /** 状态（0=正常 1=停用） */
    @Excel(name = "状态", readConverterExp = "0==正常,1==停用")
    private String status;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long sort;

    /** 产品名称 */
    private String productName;

    /** 产品规格 */
    private String specification;

    /** 产品封面图 */
    private String cover;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpecification() {
        return specification;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("specification", getSpecification())
            .append("cover", getCover())
            .append("position", getPosition())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("sort", getSort())
            .toString();
    }
}
