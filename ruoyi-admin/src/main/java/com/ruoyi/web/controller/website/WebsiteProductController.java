package com.ruoyi.website.controller;

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
import com.ruoyi.website.domain.WebsiteProduct;
import com.ruoyi.website.service.IWebsiteProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品展示Controller
 * 
 * @author luojiwei
 * @date 2025-06-24
 */
@RestController
@RequestMapping("/website/product")
public class WebsiteProductController extends BaseController
{
    @Autowired
    private IWebsiteProductService websiteProductService;

    /**
     * 查询产品展示列表
     */
    @PreAuthorize("@ss.hasPermi('website:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(WebsiteProduct websiteProduct)
    {
        startPage();
        List<WebsiteProduct> list = websiteProductService.selectWebsiteProductList(websiteProduct);
        return getDataTable(list);
    }

    /**
     * 导出产品展示列表
     */
    @PreAuthorize("@ss.hasPermi('website:product:export')")
    @Log(title = "产品展示", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WebsiteProduct websiteProduct)
    {
        List<WebsiteProduct> list = websiteProductService.selectWebsiteProductList(websiteProduct);
        ExcelUtil<WebsiteProduct> util = new ExcelUtil<WebsiteProduct>(WebsiteProduct.class);
        util.exportExcel(response, list, "产品展示数据");
    }

    /**
     * 获取产品展示详细信息
     */
    @PreAuthorize("@ss.hasPermi('website:product:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(websiteProductService.selectWebsiteProductById(id));
    }

    /**
     * 新增产品展示
     */
    @PreAuthorize("@ss.hasPermi('website:product:add')")
    @Log(title = "产品展示", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WebsiteProduct websiteProduct)
    {
        return toAjax(websiteProductService.insertWebsiteProduct(websiteProduct));
    }

    /**
     * 修改产品展示
     */
    @PreAuthorize("@ss.hasPermi('website:product:edit')")
    @Log(title = "产品展示", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebsiteProduct websiteProduct)
    {
        return toAjax(websiteProductService.updateWebsiteProduct(websiteProduct));
    }

    /**
     * 删除产品展示
     */
    @PreAuthorize("@ss.hasPermi('website:product:remove')")
    @Log(title = "产品展示", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(websiteProductService.deleteWebsiteProductByIds(ids));
    }
}
