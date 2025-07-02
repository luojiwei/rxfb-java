package com.ruoyi.prod.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品信息对象 prod_product
 * 
 * @author luojiwei
 * @date 2025-06-11
 */
public class ProdProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品ID */
    private Long productId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String productCode;

    /** 分类ID */
    @Excel(name = "分类ID")
    private Long categoryId;

    /** 商品封面 */
    @Excel(name = "商品封面")
    private String cover;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specification;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String unit;

    /** 标准售价 */
    @Excel(name = "标准售价")
    private BigDecimal price;

    /** 成本价 */
    @Excel(name = "成本价")
    private BigDecimal costPrice;

    /** 库存预警值 */
    @Excel(name = "库存预警值")
    private Long stockWarn;

    /** 商品图URL */
    @Excel(name = "商品图URL")
    private String images;

    /** 状态(0正常 1停售) */
    @Excel(name = "状态(0正常 1停售)")
    private String status;

    /** 产品简介 */
    @Excel(name = "产品简介")
    private String productIntro;

    /** 删除标志(0存在 1删除) */
    private String delFlag;

    /** 技术参数图 */
    @Excel(name = "技术参数图")
    private String technicalSpecification;

    /** 标签 */
    @Excel(name = "标签")
    private String tags;

    /** 型号组合名 */
    @Excel(name = "型号组合名")
    private String specGroup;

    public String getSpecGroup() {
        return specGroup;
    }

    public void setSpecGroup(String specGroup) {
        this.specGroup = specGroup;
    }

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }

    public void setProductCode(String productCode) 
    {
        this.productCode = productCode;
    }

    public String getProductCode() 
    {
        return productCode;
    }

    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setSpecification(String specification)
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }

    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setCostPrice(BigDecimal costPrice) 
    {
        this.costPrice = costPrice;
    }

    public BigDecimal getCostPrice() 
    {
        return costPrice;
    }

    public void setStockWarn(Long stockWarn) 
    {
        this.stockWarn = stockWarn;
    }

    public Long getStockWarn() 
    {
        return stockWarn;
    }

    public void setImages(String images) 
    {
        this.images = images;
    }

    public String getImages() 
    {
        return images;
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

    public void setProductIntro(String productIntro) {
        this.productIntro = productIntro;
    }

    public String getProductIntro() {
        return productIntro;
    }

    public String getTechnicalSpecification() {
        return technicalSpecification;
    }

    public void setTechnicalSpecification(String technicalSpecification) {
        this.technicalSpecification = technicalSpecification;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("productCode", getProductCode())
            .append("categoryId", getCategoryId())
            .append("cover", getCover())
            .append("specification", getSpecification())
            .append("unit", getUnit())
            .append("price", getPrice())
            .append("costPrice", getCostPrice())
            .append("stockWarn", getStockWarn())
            .append("images", getImages())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("productIntro", getProductIntro())
            .append("technicalSpecification", getTechnicalSpecification())
            .append("tags", getTags())
            .append("specGroup", getSpecGroup())
            .toString();
    }
}
