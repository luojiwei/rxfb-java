package com.ruoyi.prod.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.prod.domain.ProdCategory;
import com.ruoyi.prod.domain.vo.ProductQueryVo;
import com.ruoyi.prod.mapper.ProdCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.prod.mapper.ProdProductMapper;
import com.ruoyi.prod.domain.ProdProduct;
import com.ruoyi.prod.service.IProdProductService;
import org.springframework.util.CollectionUtils;

/**
 * 产品信息Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-11
 */
@Service
public class ProdProductServiceImpl implements IProdProductService 
{
    @Autowired(required = false)
    private ProdProductMapper prodProductMapper;

    @Autowired(required = false)
    private ProdCategoryMapper prodCategoryMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /** 产品编码前缀 */
    private static final String PRODUCT_CODE_PREFIX = "PROD";

    /** 产品编码缓存键 */
    private static final String PRODUCT_CODE_CACHE_KEY = CacheConstants.PRODUCT_CODE_KEY;

    /**
     * 查询产品信息
     * 
     * @param productId 产品信息主键
     * @return 产品信息
     */
    @Override
    public ProdProduct selectProdProductByProductId(Long productId)
    {
        return prodProductMapper.selectProdProductByProductId(productId);
    }

    /**
     * 查询产品信息列表
     * 
     * @param queryVo 产品信息
     * @return 产品信息
     */
    @Override
    public List<ProdProduct> selectProdProductList(ProductQueryVo queryVo)
    {
        // 如果需要包含子分类，查询所有子分类ID
        if (Boolean.TRUE.equals(queryVo.getIncludeChild()) && queryVo.getCategoryId() != null) {
            List<Long> categoryIds = selectSubCategoryIds(queryVo.getCategoryId());
            queryVo.setCategoryIds(categoryIds);
        }
        return prodProductMapper.selectProdProductList(queryVo);
    }

    /**
     * 搜索产品信息列表
     *
     * @param queryVo 产品信息
     * @return 产品信息
     */
    @Override
    public List<ProdProduct> searchProductList(ProductQueryVo queryVo)
    {
        return prodProductMapper.searchProductList(queryVo);
    }

    /**
     * 新增产品信息
     * 
     * @param prodProduct 产品信息
     * @return 结果
     */
    @Override
    public int insertProdProduct(ProdProduct prodProduct)
    {
        // 自动生成产品编码
        if (StringUtils.isEmpty(prodProduct.getProductCode())) {
            prodProduct.setProductCode(generateProductCode());
        }

        prodProduct.setCreateBy(SecurityUtils.getUsername());
        prodProduct.setCreateTime(DateUtils.getNowDate());
        return prodProductMapper.insertProdProduct(prodProduct);
    }

    /**
     * 修改产品信息
     * 
     * @param prodProduct 产品信息
     * @return 结果
     */
    @Override
    public int updateProdProduct(ProdProduct prodProduct)
    {
        prodProduct.setUpdateBy(SecurityUtils.getUsername());
        prodProduct.setUpdateTime(DateUtils.getNowDate());
        return prodProductMapper.updateProdProduct(prodProduct);
    }

    /**
     * 批量删除产品信息
     * 
     * @param productIds 需要删除的产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProdProductByProductIds(Long[] productIds)
    {
        return prodProductMapper.deleteProdProductByProductIds(productIds);
    }

    /**
     * 删除产品信息信息
     * 
     * @param productId 产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProdProductByProductId(Long productId)
    {
        return prodProductMapper.deleteProdProductByProductId(productId);
    }

    @Override
    public String generateProductCode() {
        // 获取当前日期
        String dateStr = DateUtils.dateTimeNow("yyyyMMdd");

        // 构建缓存键
        String cacheKey = PRODUCT_CODE_CACHE_KEY + dateStr;

        // 使用RedisTemplate的increment方法，注意key类型转换
        Long sequence = redisTemplate.opsForValue().increment(cacheKey, 1);

        // 设置缓存过期时间为当天结束
        if (sequence == 1) {
            // 计算到当天结束的秒数
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            long expireSeconds = (calendar.getTimeInMillis() - System.currentTimeMillis()) / 1000;
            redisTemplate.expire(cacheKey, expireSeconds, TimeUnit.SECONDS);
        }

        // 格式化流水号为固定长度（例如4位）
        String formattedSequence = String.format("%04d", sequence);

        // 组合产品编码：前缀 + 日期 + 流水号
        return PRODUCT_CODE_PREFIX + dateStr + formattedSequence;
    }

    @Override
    public List<Long> selectSubCategoryIds(Long categoryId) {
        List<Long> categoryIds = new ArrayList<>();
        if (categoryId == null) {
            return categoryIds;
        }

        // 添加当前分类ID
        categoryIds.add(categoryId);

        // 递归查询所有子分类ID
        findSubCategoryIds(categoryId, categoryIds);

        return categoryIds;
    }

    /**
     * 递归查询所有子分类ID
     */
    private void findSubCategoryIds(Long parentId, List<Long> categoryIds) {
        List<ProdCategory> subCategories = prodCategoryMapper.selectCategoryListByParentId(parentId);
        if (!CollectionUtils.isEmpty(subCategories)) {
            for (ProdCategory category : subCategories) {
                if (category.getCategoryId() != null) {
                    categoryIds.add(category.getCategoryId());
                    findSubCategoryIds(category.getCategoryId(), categoryIds);
                }
            }
        }
    }

    @Override
    public List<ProdCategory> selectCategoryList(ProdCategory category) {
        return prodCategoryMapper.selectProdCategoryList(category);
    }
}
