package com.ruoyi.website.service;

import java.util.List;
import com.ruoyi.website.domain.WebsiteCertificate;

/**
 * 证书信息Service接口
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
public interface IWebsiteCertificateService 
{
    /**
     * 查询证书信息
     * 
     * @param certificateId 证书信息主键
     * @return 证书信息
     */
    public WebsiteCertificate selectWebsiteCertificateByCertificateId(Long certificateId);

    /**
     * 查询证书信息列表
     * 
     * @param websiteCertificate 证书信息
     * @return 证书信息集合
     */
    public List<WebsiteCertificate> selectWebsiteCertificateList(WebsiteCertificate websiteCertificate);

    /**
     * 新增证书信息
     * 
     * @param websiteCertificate 证书信息
     * @return 结果
     */
    public int insertWebsiteCertificate(WebsiteCertificate websiteCertificate);

    /**
     * 修改证书信息
     * 
     * @param websiteCertificate 证书信息
     * @return 结果
     */
    public int updateWebsiteCertificate(WebsiteCertificate websiteCertificate);

    /**
     * 批量删除证书信息
     * 
     * @param certificateIds 需要删除的证书信息主键集合
     * @return 结果
     */
    public int deleteWebsiteCertificateByCertificateIds(Long[] certificateIds);

    /**
     * 删除证书信息信息
     * 
     * @param certificateId 证书信息主键
     * @return 结果
     */
    public int deleteWebsiteCertificateByCertificateId(Long certificateId);
}
