package com.ruoyi.prod.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.prod.mapper.ProdCategoryMapper;
import com.ruoyi.prod.domain.ProdCategory;
import com.ruoyi.prod.service.IProdCategoryService;

/**
 * 产品分类Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-11
 */
@Service
public class ProdCategoryServiceImpl implements IProdCategoryService 
{
    @Autowired(required = false)
    private ProdCategoryMapper prodCategoryMapper;

    /**
     * 查询产品分类
     * 
     * @param categoryId 产品分类主键
     * @return 产品分类
     */
    @Override
    public ProdCategory selectProdCategoryByCategoryId(Long categoryId)
    {
        return prodCategoryMapper.selectProdCategoryByCategoryId(categoryId);
    }

    /**
     * 查询产品分类列表
     * 
     * @param prodCategory 产品分类
     * @return 产品分类
     */
    @Override
    public List<ProdCategory> selectProdCategoryList(ProdCategory prodCategory)
    {
        return prodCategoryMapper.selectProdCategoryList(prodCategory);
    }

    /**
     * 新增产品分类
     * 
     * @param prodCategory 产品分类
     * @return 结果
     */
    @Override
    public int insertProdCategory(ProdCategory prodCategory)
    {
        prodCategory.setCreateTime(DateUtils.getNowDate());
        return prodCategoryMapper.insertProdCategory(prodCategory);
    }

    /**
     * 修改产品分类
     * 
     * @param prodCategory 产品分类
     * @return 结果
     */
    @Override
    public int updateProdCategory(ProdCategory prodCategory)
    {
        prodCategory.setUpdateTime(DateUtils.getNowDate());
        return prodCategoryMapper.updateProdCategory(prodCategory);
    }

    /**
     * 批量删除产品分类
     * 
     * @param categoryIds 需要删除的产品分类主键
     * @return 结果
     */
    @Override
    public int deleteProdCategoryByCategoryIds(Long[] categoryIds)
    {
        return prodCategoryMapper.deleteProdCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除产品分类信息
     * 
     * @param categoryId 产品分类主键
     * @return 结果
     */
    @Override
    public int deleteProdCategoryByCategoryId(Long categoryId)
    {
        return prodCategoryMapper.deleteProdCategoryByCategoryId(categoryId);
    }

}
