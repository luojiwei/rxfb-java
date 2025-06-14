package com.ruoyi.prod.service;

import java.util.List;
import com.ruoyi.prod.domain.ProdCategory;

/**
 * 产品分类Service接口
 * 
 * @author luojiwei
 * @date 2025-06-11
 */
public interface IProdCategoryService 
{
    /**
     * 查询产品分类
     * 
     * @param categoryId 产品分类主键
     * @return 产品分类
     */
    public ProdCategory selectProdCategoryByCategoryId(Long categoryId);

    /**
     * 查询产品分类列表
     * 
     * @param prodCategory 产品分类
     * @return 产品分类集合
     */
    public List<ProdCategory> selectProdCategoryList(ProdCategory prodCategory);

    /**
     * 新增产品分类
     * 
     * @param prodCategory 产品分类
     * @return 结果
     */
    public int insertProdCategory(ProdCategory prodCategory);

    /**
     * 修改产品分类
     * 
     * @param prodCategory 产品分类
     * @return 结果
     */
    public int updateProdCategory(ProdCategory prodCategory);

    /**
     * 批量删除产品分类
     * 
     * @param categoryIds 需要删除的产品分类主键集合
     * @return 结果
     */
    public int deleteProdCategoryByCategoryIds(Long[] categoryIds);

    /**
     * 删除产品分类信息
     * 
     * @param categoryId 产品分类主键
     * @return 结果
     */
    public int deleteProdCategoryByCategoryId(Long categoryId);
}
