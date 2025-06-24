package com.ruoyi.prod.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 生产任务对象 prod_task
 * 
 * @author luojiwei
 * @date 2025-06-21
 */
public class ProdTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long taskId;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long productId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 任务数量 */
    @Excel(name = "任务数量")
    private Long taskNum;

    /** 紧急程度 */
    @Excel(name = "紧急程度")
    private String urgencyDegree;

    /** 完成状态 */
    @Excel(name = "完成状态")
    private String completionStatus;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTaskNum(Long taskNum)
    {
        this.taskNum = taskNum;
    }

    public Long getTaskNum() 
    {
        return taskNum;
    }

    public void setUrgencyDegree(String urgencyDegree) 
    {
        this.urgencyDegree = urgencyDegree;
    }

    public String getUrgencyDegree() 
    {
        return urgencyDegree;
    }

    public void setCompletionStatus(String completionStatus) 
    {
        this.completionStatus = completionStatus;
    }

    public String getCompletionStatus() 
    {
        return completionStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("taskNum", getTaskNum())
            .append("urgencyDegree", getUrgencyDegree())
            .append("completionStatus", getCompletionStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
