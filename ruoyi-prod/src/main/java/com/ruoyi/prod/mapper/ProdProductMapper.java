package com.ruoyi.prod.mapper;

import java.util.List;
import com.ruoyi.prod.domain.ProdProduct;
import com.ruoyi.prod.domain.vo.ProductQueryVo;

/**
 * 产品信息Mapper接口
 * 
 * @author luojiwei
 * @date 2025-06-11
 */
public interface ProdProductMapper 
{
    /**
     * 查询产品信息
     * 
     * @param productId 产品信息主键
     * @return 产品信息
     */
    public ProdProduct selectProdProductByProductId(Long productId);

    /**
     * 查询产品信息列表
     * 
     * @param queryVo 产品信息
     * @return 产品信息集合
     */
    public List<ProdProduct> selectProdProductList(ProductQueryVo queryVo);

    /**
     * 搜索产品信息列表
     *
     * @param queryVo 产品信息
     * @return 产品信息集合
     */
     List<ProdProduct> searchProductList(ProductQueryVo queryVo);

    /**
     * 新增产品信息
     * 
     * @param prodProduct 产品信息
     * @return 结果
     */
    public int insertProdProduct(ProdProduct prodProduct);

    /**
     * 修改产品信息
     * 
     * @param prodProduct 产品信息
     * @return 结果
     */
    public int updateProdProduct(ProdProduct prodProduct);

    /**
     * 删除产品信息
     * 
     * @param productId 产品信息主键
     * @return 结果
     */
    public int deleteProdProductByProductId(Long productId);

    /**
     * 批量删除产品信息
     * 
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProdProductByProductIds(Long[] productIds);
}
