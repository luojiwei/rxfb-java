package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class SysMail extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 邮件ID */
    private Long id;

    /** 发件人ID */
    @Excel(name = "发件人ID")
    private Long senderId;

    /** 发件人姓名 */
    @Excel(name = "发件人姓名")
    private String senderName;

    /** 邮件主题 */
    @NotBlank(message = "邮件主题不能为空")
    @Excel(name = "邮件主题")
    private String subject;

    /** 邮件内容 */
    @NotBlank(message = "邮件内容不能为空")
    @Excel(name = "邮件内容")
    private String content;

    /** 发送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendTime;

    /** 阅读状态（0未读 1已读） */
    @Excel(name = "阅读状态", readConverterExp = "0=未读,1=已读")
    private String readStatus;

    /** 邮件接收人信息 */
    private List<SysMailReceiver> sysMailReceiverList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setSenderId(Long senderId)
    {
        this.senderId = senderId;
    }

    public Long getSenderId()
    {
        return senderId;
    }

    public void setSenderName(String senderName)
    {
        this.senderName = senderName;
    }

    public String getSenderName()
    {
        return senderName;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }

    public void setSendTime(Date sendTime)
    {
        this.sendTime = sendTime;
    }

    public Date getSendTime()
    {
        return sendTime;
    }

    public void setReadStatus(String readStatus)
    {
        this.readStatus = readStatus;
    }

    public String getReadStatus()
    {
        return readStatus;
    }

    public List<SysMailReceiver> getSysMailReceiverList()
    {
        return sysMailReceiverList;
    }

    public void setSysMailReceiverList(List<SysMailReceiver> sysMailReceiverList)
    {
        this.sysMailReceiverList = sysMailReceiverList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("senderId", getSenderId())
                .append("senderName", getSenderName())
                .append("subject", getSubject())
                .append("content", getContent())
                .append("sendTime", getSendTime())
                .append("readStatus", getReadStatus())
                .append("sysMailReceiverList", getSysMailReceiverList())
                .toString();
    }
}
