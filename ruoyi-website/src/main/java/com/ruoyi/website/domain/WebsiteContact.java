package com.ruoyi.website.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 官网留言对象 website_contact
 * 
 * @author luojiwei
 * @date 2025-06-25
 */
public class WebsiteContact extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 留言ID */
    private Long contactId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String userName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 邮箱地址 */
    @Excel(name = "邮箱地址")
    private String email;

    /** 留言内容 */
    @Excel(name = "留言内容")
    private String content;

    /** 产品ID */
    @Excel(name = "产品Code")
    private String productCode;

    /** 负责人 */
    @Excel(name = "负责人")
    private Long owner;

    /** 状态（0=未联系 1=已联系） */
    @Excel(name = "状态", readConverterExp = "0==未联系,1==已联系")
    private String status;

    public void setContactId(Long contactId) 
    {
        this.contactId = contactId;
    }

    public Long getContactId() 
    {
        return contactId;
    }

    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setOwner(Long owner)
    {
        this.owner = owner;
    }

    public Long getOwner() 
    {
        return owner;
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
            .append("contactId", getContactId())
            .append("userName", getUserName())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("content", getContent())
            .append("productCode", getProductCode())
            .append("owner", getOwner())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
