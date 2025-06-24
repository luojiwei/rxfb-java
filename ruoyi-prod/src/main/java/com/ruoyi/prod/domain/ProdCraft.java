package com.ruoyi.prod.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品工艺对象 prod_craft
 * 
 * @author luojiwei
 * @date 2025-06-20
 */
public class ProdCraft extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工艺ID */
    private Long craftId;

    /** 工艺名称 */
    @Excel(name = "工艺名称")
    private String craftName;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long productId;

    /** 总装图 */
    private String generalAssemblyDrawing;

    /** 配件设计图 */
    private String accessoryDesignDrawing;

    /** 3D模型图 */
    private String model3dDiagram;

    /** 装配配件清单 */
    private String assemblyPartsList;

    /** 电气原理图 */
    private String electricalSchematicDiagram;

    /** 电气接线图 */
    private String wiringDiagram;

    /** 各类标签示意图 */
    private String markingExampleDiagram;

    /** 受控明细 */
    private String controlledDetails;

    /** 实物照片 */
    private String entityPhoto;

    /** 3C证书 */
    private String certification3c;

    /** MA证书 */
    private String certificationMa;

    /** 防爆证书 */
    private String certificationEp;

    /** 产品名称 */
    private String productName;

    /** 产品型号 */
    private String specification;

    /** 产品搜索词 */
    private String keyword;

    /** 状态（0=正常 1=停用） */
    @Excel(name = "状态", readConverterExp = "0==正常,1==停用")
    private String status;

    public void setCraftId(Long craftId) 
    {
        this.craftId = craftId;
    }

    public Long getCraftId() 
    {
        return craftId;
    }

    public void setCraftName(String craftName) 
    {
        this.craftName = craftName;
    }

    public String getCraftName() 
    {
        return craftName;
    }

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setGeneralAssemblyDrawing(String generalAssemblyDrawing) 
    {
        this.generalAssemblyDrawing = generalAssemblyDrawing;
    }

    public String getGeneralAssemblyDrawing() 
    {
        return generalAssemblyDrawing;
    }

    public void setAccessoryDesignDrawing(String accessoryDesignDrawing) 
    {
        this.accessoryDesignDrawing = accessoryDesignDrawing;
    }

    public String getAccessoryDesignDrawing() 
    {
        return accessoryDesignDrawing;
    }

    public void setModel3dDiagram(String model3dDiagram) 
    {
        this.model3dDiagram = model3dDiagram;
    }

    public String getModel3dDiagram() 
    {
        return model3dDiagram;
    }

    public void setAssemblyPartsList(String assemblyPartsList) 
    {
        this.assemblyPartsList = assemblyPartsList;
    }

    public String getAssemblyPartsList() 
    {
        return assemblyPartsList;
    }

    public void setElectricalSchematicDiagram(String electricalSchematicDiagram) 
    {
        this.electricalSchematicDiagram = electricalSchematicDiagram;
    }

    public String getElectricalSchematicDiagram() 
    {
        return electricalSchematicDiagram;
    }

    public void setWiringDiagram(String wiringDiagram) 
    {
        this.wiringDiagram = wiringDiagram;
    }

    public String getWiringDiagram() 
    {
        return wiringDiagram;
    }

    public void setMarkingExampleDiagram(String markingExampleDiagram) 
    {
        this.markingExampleDiagram = markingExampleDiagram;
    }

    public String getMarkingExampleDiagram() 
    {
        return markingExampleDiagram;
    }

    public void setControlledDetails(String controlledDetails) 
    {
        this.controlledDetails = controlledDetails;
    }

    public String getControlledDetails() 
    {
        return controlledDetails;
    }

    public void setEntityPhoto(String entityPhoto) 
    {
        this.entityPhoto = entityPhoto;
    }

    public String getEntityPhoto() 
    {
        return entityPhoto;
    }

    public void setCertification3c(String certification3c) 
    {
        this.certification3c = certification3c;
    }

    public String getCertification3c() 
    {
        return certification3c;
    }

    public void setCertificationMa(String certificationMa) 
    {
        this.certificationMa = certificationMa;
    }

    public String getCertificationMa() 
    {
        return certificationMa;
    }

    public void setCertificationEp(String certificationEp) 
    {
        this.certificationEp = certificationEp;
    }

    public String getCertificationEp() 
    {
        return certificationEp;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("craftId", getCraftId())
            .append("craftName", getCraftName())
            .append("productId", getProductId())
            .append("generalAssemblyDrawing", getGeneralAssemblyDrawing())
            .append("accessoryDesignDrawing", getAccessoryDesignDrawing())
            .append("model3dDiagram", getModel3dDiagram())
            .append("assemblyPartsList", getAssemblyPartsList())
            .append("electricalSchematicDiagram", getElectricalSchematicDiagram())
            .append("wiringDiagram", getWiringDiagram())
            .append("markingExampleDiagram", getMarkingExampleDiagram())
            .append("controlledDetails", getControlledDetails())
            .append("entityPhoto", getEntityPhoto())
            .append("certification3c", getCertification3c())
            .append("certificationMa", getCertificationMa())
            .append("certificationEp", getCertificationEp())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("productName", getProductName())
            .append("specification", getSpecification())
            .append("keyword", getKeyword())
            .toString();
    }
}
