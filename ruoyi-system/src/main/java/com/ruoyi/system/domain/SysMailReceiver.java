package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 邮件接收人对象 sys_mail_receiver
 *
 * @author luojiwei
 * @date 2025-06-15
 */
public class SysMailReceiver extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 邮件ID */
    @Excel(name = "邮件ID")
    private Long mailId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 接收类型（0收件人 1抄送人） */
    @Excel(name = "接收类型", readConverterExp = "0=收件人,1=抄送人")
    private String type;

    /** 阅读状态（0未读 1已读） */
    @Excel(name = "阅读状态", readConverterExp = "0=未读,1=已读")
    private String readStatus;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setMailId(Long mailId)
    {
        this.mailId = mailId;
    }

    public Long getMailId()
    {
        return mailId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
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
                .append("id", getId())
                .append("mailId", getMailId())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("type", getType())
                .append("readStatus", getReadStatus())
                .toString();
    }
}
