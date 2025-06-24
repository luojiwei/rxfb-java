package com.ruoyi.website.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 官网信息对象 website_home
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
public class WebsiteHome extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 公司Logo */
    @Excel(name = "公司Logo")
    private String companyLogo;

    /** 公司简介 */
    @Excel(name = "公司简介")
    private String companyIntro;

    /** 公司地址 */
    @Excel(name = "公司地址")
    private String address;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 手机号 */
    @Excel(name = "手机号")
    private String mobile;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String companyTel;

    /** 传真号 */
    @Excel(name = "传真号")
    private String companyFax;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyIntro() {
        return companyIntro;
    }

    public void setCompanyIntro(String companyIntro) {
        this.companyIntro = companyIntro;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("companyName", getCompanyName())
                .append("companyLogo", getCompanyLogo())
                .append("companyIntro", getCompanyIntro())
                .append("address", getAddress())
                .append("contacts", getContacts())
                .append("mobile", getMobile())
                .append("companyTel", getCompanyTel())
                .append("companyFax", getCompanyFax())
                .toString();
    }
}
