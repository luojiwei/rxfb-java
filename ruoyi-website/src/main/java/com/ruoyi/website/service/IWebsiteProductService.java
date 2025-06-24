package com.ruoyi.website.service;

import java.util.List;
import com.ruoyi.website.domain.WebsiteProduct;

/**
 * 产品展示Service接口
 * 
 * @author luojiwei
 * @date 2025-06-24
 */
public interface IWebsiteProductService 
{
    /**
     * 查询产品展示
     * 
     * @param id 产品展示主键
     * @return 产品展示
     */
    public WebsiteProduct selectWebsiteProductById(Long id);

    /**
     * 查询产品展示列表
     * 
     * @param websiteProduct 产品展示
     * @return 产品展示集合
     */
    public List<WebsiteProduct> selectWebsiteProductList(WebsiteProduct websiteProduct);

    /**
     * 新增产品展示
     * 
     * @param websiteProduct 产品展示
     * @return 结果
     */
    public int insertWebsiteProduct(WebsiteProduct websiteProduct);

    /**
     * 修改产品展示
     * 
     * @param websiteProduct 产品展示
     * @return 结果
     */
    public int updateWebsiteProduct(WebsiteProduct websiteProduct);

    /**
     * 批量删除产品展示
     * 
     * @param ids 需要删除的产品展示主键集合
     * @return 结果
     */
    public int deleteWebsiteProductByIds(Long[] ids);

    /**
     * 删除产品展示信息
     * 
     * @param id 产品展示主键
     * @return 结果
     */
    public int deleteWebsiteProductById(Long id);
}
