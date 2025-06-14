package com.ruoyi.website.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.website.mapper.WebsiteCertificateMapper;
import com.ruoyi.website.domain.WebsiteCertificate;
import com.ruoyi.website.service.IWebsiteCertificateService;

/**
 * 证书信息Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@Service
public class WebsiteCertificateServiceImpl implements IWebsiteCertificateService 
{
    @Autowired
    private WebsiteCertificateMapper websiteCertificateMapper;

    /**
     * 查询证书信息
     * 
     * @param certificateId 证书信息主键
     * @return 证书信息
     */
    @Override
    public WebsiteCertificate selectWebsiteCertificateByCertificateId(Long certificateId)
    {
        return websiteCertificateMapper.selectWebsiteCertificateByCertificateId(certificateId);
    }

    /**
     * 查询证书信息列表
     * 
     * @param websiteCertificate 证书信息
     * @return 证书信息
     */
    @Override
    public List<WebsiteCertificate> selectWebsiteCertificateList(WebsiteCertificate websiteCertificate)
    {
        return websiteCertificateMapper.selectWebsiteCertificateList(websiteCertificate);
    }

    /**
     * 新增证书信息
     * 
     * @param websiteCertificate 证书信息
     * @return 结果
     */
    @Override
    public int insertWebsiteCertificate(WebsiteCertificate websiteCertificate)
    {
        websiteCertificate.setCreateBy(SecurityUtils.getUsername());
        websiteCertificate.setCreateTime(DateUtils.getNowDate());
        return websiteCertificateMapper.insertWebsiteCertificate(websiteCertificate);
    }

    /**
     * 修改证书信息
     * 
     * @param websiteCertificate 证书信息
     * @return 结果
     */
    @Override
    public int updateWebsiteCertificate(WebsiteCertificate websiteCertificate)
    {
        websiteCertificate.setUpdateBy(SecurityUtils.getUsername());
        websiteCertificate.setUpdateTime(DateUtils.getNowDate());
        return websiteCertificateMapper.updateWebsiteCertificate(websiteCertificate);
    }

    /**
     * 批量删除证书信息
     * 
     * @param certificateIds 需要删除的证书信息主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteCertificateByCertificateIds(Long[] certificateIds)
    {
        return websiteCertificateMapper.deleteWebsiteCertificateByCertificateIds(certificateIds);
    }

    /**
     * 删除证书信息信息
     * 
     * @param certificateId 证书信息主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteCertificateByCertificateId(Long certificateId)
    {
        return websiteCertificateMapper.deleteWebsiteCertificateByCertificateId(certificateId);
    }
}
