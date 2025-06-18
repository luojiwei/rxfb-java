package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 通知信息对象 sys_notified
 * 
 * @author luojiwei
 * @date 2025-06-17
 */
public class SysNotified extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long notifiedId;

    /** 通知类型 */
    @Excel(name = "通知类型")
    private String notifiedType;

    /** 通知内容 */
    @Excel(name = "通知内容")
    private String content;

    /** 关联ID */
    @Excel(name = "关联ID")
    private Long refId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 阅读状态（0未读 1已读） */
    @Excel(name = "阅读状态", readConverterExp = "0=未读,1=已读")
    private String readStatus;

    private Date startTime;

    private Date endTime;

    private Long[] notifiedIds;

    public Long[] getNotifiedIds() {
        return notifiedIds;
    }

    public void setNotifiedIds(Long[] notifiedIds) {
        this.notifiedIds = notifiedIds;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setNotifiedId(Long notifiedId)
    {
        this.notifiedId = notifiedId;
    }

    public Long getNotifiedId() 
    {
        return notifiedId;
    }

    public void setNotifiedType(String notifiedType) 
    {
        this.notifiedType = notifiedType;
    }

    public String getNotifiedType() 
    {
        return notifiedType;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setRefId(Long refId) 
    {
        this.refId = refId;
    }

    public Long getRefId() 
    {
        return refId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setReadStatus(String readStatus) 
    {
        this.readStatus = readStatus;
    }

    public String getReadStatus() 
    {
        return readStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("notifiedId", getNotifiedId())
            .append("notifiedType", getNotifiedType())
            .append("createTime", getCreateTime())
            .append("content", getContent())
            .append("refId", getRefId())
            .append("userId", getUserId())
            .append("readStatus", getReadStatus())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("notifiedIds", getNotifiedIds())
            .toString();
    }
}
