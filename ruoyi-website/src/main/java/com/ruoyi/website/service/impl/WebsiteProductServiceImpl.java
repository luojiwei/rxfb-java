package com.ruoyi.website.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.website.mapper.WebsiteProductMapper;
import com.ruoyi.website.domain.WebsiteProduct;
import com.ruoyi.website.service.IWebsiteProductService;

/**
 * 产品展示Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-24
 */
@Service
public class WebsiteProductServiceImpl implements IWebsiteProductService 
{
    @Autowired
    private WebsiteProductMapper websiteProductMapper;

    /**
     * 查询产品展示
     * 
     * @param id 产品展示主键
     * @return 产品展示
     */
    @Override
    public WebsiteProduct selectWebsiteProductById(Long id)
    {
        return websiteProductMapper.selectWebsiteProductById(id);
    }

    /**
     * 查询产品展示列表
     * 
     * @param websiteProduct 产品展示
     * @return 产品展示
     */
    @Override
    public List<WebsiteProduct> selectWebsiteProductList(WebsiteProduct websiteProduct)
    {
        return websiteProductMapper.selectWebsiteProductList(websiteProduct);
    }

    /**
     * 新增产品展示
     * 
     * @param websiteProduct 产品展示
     * @return 结果
     */
    @Override
    public int insertWebsiteProduct(WebsiteProduct websiteProduct)
    {
        websiteProduct.setCreateBy(SecurityUtils.getUsername());
        websiteProduct.setCreateTime(DateUtils.getNowDate());
        return websiteProductMapper.insertWebsiteProduct(websiteProduct);
    }

    /**
     * 修改产品展示
     * 
     * @param websiteProduct 产品展示
     * @return 结果
     */
    @Override
    public int updateWebsiteProduct(WebsiteProduct websiteProduct)
    {
        websiteProduct.setUpdateBy(SecurityUtils.getUsername());
        websiteProduct.setUpdateTime(DateUtils.getNowDate());
        return websiteProductMapper.updateWebsiteProduct(websiteProduct);
    }

    /**
     * 批量删除产品展示
     * 
     * @param ids 需要删除的产品展示主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteProductByIds(Long[] ids)
    {
        return websiteProductMapper.deleteWebsiteProductByIds(ids);
    }

    /**
     * 删除产品展示信息
     * 
     * @param id 产品展示主键
     * @return 结果
     */
    @Override
    public int deleteWebsiteProductById(Long id)
    {
        return websiteProductMapper.deleteWebsiteProductById(id);
    }
}
