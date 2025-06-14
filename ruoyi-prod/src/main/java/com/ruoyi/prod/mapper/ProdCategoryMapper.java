package com.ruoyi.prod.mapper;

import java.util.List;
import com.ruoyi.prod.domain.ProdCategory;

/**
 * 产品分类Mapper接口
 * 
 * @author luojiwei
 * @date 2025-06-11
 */
public interface ProdCategoryMapper 
{
    /**
     * 查询产品分类
     * 
     * @param categoryId 产品分类主键
     * @return 产品分类
     */
    ProdCategory selectProdCategoryByCategoryId(Long categoryId);

    /**
     * 查询产品分类列表
     * 
     * @param prodCategory 产品分类
     * @return 产品分类集合
     */
    List<ProdCategory> selectProdCategoryList(ProdCategory prodCategory);

    /**
     * 新增产品分类
     * 
     * @param prodCategory 产品分类
     * @return 结果
     */
    int insertProdCategory(ProdCategory prodCategory);

    /**
     * 修改产品分类
     * 
     * @param prodCategory 产品分类
     * @return 结果
     */
    int updateProdCategory(ProdCategory prodCategory);

    /**
     * 删除产品分类
     * 
     * @param categoryId 产品分类主键
     * @return 结果
     */
     int deleteProdCategoryByCategoryId(Long categoryId);

    /**
     * 批量删除产品分类
     * 
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    int deleteProdCategoryByCategoryIds(Long[] categoryIds);

    /**
     * 根据父分类ID查询分类列表
     *
     * @param parentId 父分类ID
     * @return 分类列表
     */
    List<ProdCategory> selectCategoryListByParentId(Long parentId);
}
