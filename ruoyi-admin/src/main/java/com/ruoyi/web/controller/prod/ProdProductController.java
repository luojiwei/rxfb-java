package com.ruoyi.web.controller.prod;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.prod.domain.vo.ProductQueryVo;
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
import com.ruoyi.prod.domain.ProdProduct;
import com.ruoyi.prod.service.IProdProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品信息Controller
 * 
 * @author luojiwei
 * @date 2025-06-11
 */
@RestController
@RequestMapping("/prod/product")
public class ProdProductController extends BaseController
{
    @Autowired
    private IProdProductService prodProductService;

    /**
     * 查询产品信息列表
     */
    @PreAuthorize("@ss.hasPermi('prod:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductQueryVo queryVo)
    {
        startPage();
        List<ProdProduct> list = prodProductService.selectProdProductList(queryVo);
        return getDataTable(list);
    }

    /**
     * 查询产品信息列表
     */
    @PreAuthorize("@ss.hasPermi('prod:product:search')")
    @GetMapping("/search")
    public AjaxResult search(ProductQueryVo queryVo) {
        return success(prodProductService.searchProductList(queryVo));
    }

    /**
     * 导出产品信息列表
     */
    @PreAuthorize("@ss.hasPermi('prod:product:export')")
    @Log(title = "产品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductQueryVo queryVo)
    {
        List<ProdProduct> list = prodProductService.selectProdProductList(queryVo);
        ExcelUtil<ProdProduct> util = new ExcelUtil<ProdProduct>(ProdProduct.class);
        util.exportExcel(response, list, "产品信息数据");
    }

    /**
     * 获取产品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('prod:product:query')")
    @GetMapping(value = "/{productId}")
    public AjaxResult getInfo(@PathVariable("productId") Long productId)
    {
        return success(prodProductService.selectProdProductByProductId(productId));
    }

    /**
     * 新增产品信息
     */
    @PreAuthorize("@ss.hasPermi('prod:product:add')")
    @Log(title = "产品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProdProduct prodProduct)
    {
        return toAjax(prodProductService.insertProdProduct(prodProduct));
    }

    /**
     * 修改产品信息
     */
    @PreAuthorize("@ss.hasPermi('prod:product:edit')")
    @Log(title = "产品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProdProduct prodProduct)
    {
        return toAjax(prodProductService.updateProdProduct(prodProduct));
    }

    /**
     * 删除产品信息
     */
    @PreAuthorize("@ss.hasPermi('prod:product:remove')")
    @Log(title = "产品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Long[] productIds)
    {
        return toAjax(prodProductService.deleteProdProductByProductIds(productIds));
    }

}
