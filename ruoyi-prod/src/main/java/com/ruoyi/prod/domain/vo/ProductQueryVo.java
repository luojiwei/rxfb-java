package com.ruoyi.prod.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * 产品查询条件VO
 */
@Data
public class ProductQueryVo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /** 当前页 */
    private Integer pageNum;
    
    /** 每页大小 */
    private Integer pageSize;
    
    /** 产品名称 */
    private String productName;
    
    /** 产品编码 */
    private String productCode;
    
    /** 分类ID */
    private Long categoryId;
    
    /** 分类ID列表（用于查询子分类） */
    private List<Long> categoryIds;

    /** 产品型号 */
    private String specification;
    
    /** 是否包含子分类产品（true包含 false不包含） */
    private Boolean includeChild;
    
    /** 状态（0正常 1停用） */
    private String status;

    /** 搜索关键词 */
    private String keyword;
}
