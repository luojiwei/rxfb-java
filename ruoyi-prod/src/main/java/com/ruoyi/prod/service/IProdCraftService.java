package com.ruoyi.prod.service;

import java.util.List;
import com.ruoyi.prod.domain.ProdCraft;

/**
 * 产品工艺Service接口
 * 
 * @author luojiwei
 * @date 2025-06-20
 */
public interface IProdCraftService 
{
    /**
     * 查询产品工艺
     * 
     * @param craftId 产品工艺主键
     * @return 产品工艺
     */
    public ProdCraft selectProdCraftByCraftId(Long craftId);

    /**
     * 查询产品工艺
     *
     * @param productId 产品ID
     * @return 产品工艺
     */
    public ProdCraft selectProdCraftByProductId(Long productId);

    /**
     * 查询产品工艺列表
     * 
     * @param prodCraft 产品工艺
     * @return 产品工艺集合
     */
    public List<ProdCraft> selectProdCraftList(ProdCraft prodCraft);

    /**
     * 新增产品工艺
     * 
     * @param prodCraft 产品工艺
     * @return 结果
     */
    public int insertProdCraft(ProdCraft prodCraft);

    /**
     * 修改产品工艺
     * 
     * @param prodCraft 产品工艺
     * @return 结果
     */
    public int updateProdCraft(ProdCraft prodCraft);

    /**
     * 批量删除产品工艺
     * 
     * @param craftIds 需要删除的产品工艺主键集合
     * @return 结果
     */
    public int deleteProdCraftByCraftIds(Long[] craftIds);

    /**
     * 删除产品工艺信息
     * 
     * @param craftId 产品工艺主键
     * @return 结果
     */
    public int deleteProdCraftByCraftId(Long craftId);
}
