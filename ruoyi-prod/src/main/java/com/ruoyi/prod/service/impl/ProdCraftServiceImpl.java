package com.ruoyi.prod.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.prod.mapper.ProdCraftMapper;
import com.ruoyi.prod.domain.ProdCraft;
import com.ruoyi.prod.service.IProdCraftService;

/**
 * 产品工艺Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-20
 */
@Service
public class ProdCraftServiceImpl implements IProdCraftService 
{
    @Autowired
    private ProdCraftMapper prodCraftMapper;

    /**
     * 查询产品工艺
     * 
     * @param craftId 产品工艺主键
     * @return 产品工艺
     */
    @Override
    public ProdCraft selectProdCraftByCraftId(Long craftId)
    {
        return prodCraftMapper.selectProdCraftByCraftId(craftId);
    }

    /**
     * 查询产品工艺
     *
     * @param productId 产品ID
     * @return 产品工艺
     */
    @Override
    public ProdCraft selectProdCraftByProductId(Long productId)
    {
        return prodCraftMapper.selectProdCraftByProductId(productId);
    }

    /**
     * 查询产品工艺列表
     * 
     * @param prodCraft 产品工艺
     * @return 产品工艺
     */
    @Override
    public List<ProdCraft> selectProdCraftList(ProdCraft prodCraft)
    {
        return prodCraftMapper.selectProdCraftList(prodCraft);
    }

    /**
     * 新增产品工艺
     * 
     * @param prodCraft 产品工艺
     * @return 结果
     */
    @Override
    public int insertProdCraft(ProdCraft prodCraft)
    {
        prodCraft.setCreateTime(DateUtils.getNowDate());
        return prodCraftMapper.insertProdCraft(prodCraft);
    }

    /**
     * 修改产品工艺
     * 
     * @param prodCraft 产品工艺
     * @return 结果
     */
    @Override
    public int updateProdCraft(ProdCraft prodCraft)
    {
        prodCraft.setUpdateTime(DateUtils.getNowDate());
        return prodCraftMapper.updateProdCraft(prodCraft);
    }

    /**
     * 批量删除产品工艺
     * 
     * @param craftIds 需要删除的产品工艺主键
     * @return 结果
     */
    @Override
    public int deleteProdCraftByCraftIds(Long[] craftIds)
    {
        return prodCraftMapper.deleteProdCraftByCraftIds(craftIds);
    }

    /**
     * 删除产品工艺信息
     * 
     * @param craftId 产品工艺主键
     * @return 结果
     */
    @Override
    public int deleteProdCraftByCraftId(Long craftId)
    {
        return prodCraftMapper.deleteProdCraftByCraftId(craftId);
    }
}
