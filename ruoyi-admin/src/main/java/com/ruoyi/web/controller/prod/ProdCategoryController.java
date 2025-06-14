package com.ruoyi.web.controller.prod;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.prod.domain.ProdCategory;
import com.ruoyi.prod.service.IProdCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 产品分类Controller
 * 
 * @author luojiwei
 * @date 2025-06-11
 */
@RestController
@RequestMapping("/prod/category")
public class ProdCategoryController extends BaseController
{
    @Autowired
    private IProdCategoryService prodCategoryService;

    /**
     * 查询产品分类列表
     */
    @PreAuthorize("@ss.hasPermi('prod:category:list')")
    @GetMapping("/list")
    public AjaxResult list(ProdCategory prodCategory)
    {
        List<ProdCategory> list = prodCategoryService.selectProdCategoryList(prodCategory);
        return success(list);
    }

    /**
     * 导出产品分类列表
     */
    @PreAuthorize("@ss.hasPermi('prod:category:export')")
    @Log(title = "产品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProdCategory prodCategory)
    {
        List<ProdCategory> list = prodCategoryService.selectProdCategoryList(prodCategory);
        ExcelUtil<ProdCategory> util = new ExcelUtil<ProdCategory>(ProdCategory.class);
        util.exportExcel(response, list, "产品分类数据");
    }

    /**
     * 获取产品分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('prod:category:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return success(prodCategoryService.selectProdCategoryByCategoryId(categoryId));
    }

    /**
     * 新增产品分类
     */
    @PreAuthorize("@ss.hasPermi('prod:category:add')")
    @Log(title = "产品分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProdCategory prodCategory)
    {
        return toAjax(prodCategoryService.insertProdCategory(prodCategory));
    }

    /**
     * 修改产品分类
     */
    @PreAuthorize("@ss.hasPermi('prod:category:edit')")
    @Log(title = "产品分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProdCategory prodCategory)
    {
        return toAjax(prodCategoryService.updateProdCategory(prodCategory));
    }

    /**
     * 删除产品分类
     */
    @PreAuthorize("@ss.hasPermi('prod:category:remove')")
    @Log(title = "产品分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long[] categoryIds)
    {
        return toAjax(prodCategoryService.deleteProdCategoryByCategoryIds(categoryIds));
    }
}
