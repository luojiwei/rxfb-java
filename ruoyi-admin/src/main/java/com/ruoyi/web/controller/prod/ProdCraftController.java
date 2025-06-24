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
import com.ruoyi.prod.domain.ProdCraft;
import com.ruoyi.prod.service.IProdCraftService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品工艺Controller
 * 
 * @author luojiwei
 * @date 2025-06-20
 */
@RestController
@RequestMapping("/prod/craft")
public class ProdCraftController extends BaseController
{
    @Autowired
    private IProdCraftService prodCraftService;

    /**
     * 查询产品工艺列表
     */
    @PreAuthorize("@ss.hasPermi('prod:craft:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProdCraft prodCraft)
    {
        startPage();
        List<ProdCraft> list = prodCraftService.selectProdCraftList(prodCraft);
        return getDataTable(list);
    }

    /**
     * 导出产品工艺列表
     */
    @PreAuthorize("@ss.hasPermi('prod:craft:export')")
    @Log(title = "产品工艺", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProdCraft prodCraft)
    {
        List<ProdCraft> list = prodCraftService.selectProdCraftList(prodCraft);
        ExcelUtil<ProdCraft> util = new ExcelUtil<ProdCraft>(ProdCraft.class);
        util.exportExcel(response, list, "产品工艺数据");
    }

    /**
     * 获取产品工艺详细信息
     */
    @PreAuthorize("@ss.hasPermi('prod:craft:query')")
    @GetMapping(value = "/{craftId}")
    public AjaxResult getInfo(@PathVariable("craftId") Long craftId)
    {
        return success(prodCraftService.selectProdCraftByCraftId(craftId));
    }

    /**
     * 获取产品工艺详细信息
     */
    @PreAuthorize("@ss.hasPermi('prod:craft:query')")
    @GetMapping(value = "/getDetails/{productId}")
    public AjaxResult getDetails(@PathVariable("productId") Long productId)
    {
        return success(prodCraftService.selectProdCraftByProductId(productId));
    }

    /**
     * 新增产品工艺
     */
    @PreAuthorize("@ss.hasPermi('prod:craft:add')")
    @Log(title = "产品工艺", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProdCraft prodCraft)
    {
        return toAjax(prodCraftService.insertProdCraft(prodCraft));
    }

    /**
     * 修改产品工艺
     */
    @PreAuthorize("@ss.hasPermi('prod:craft:edit')")
    @Log(title = "产品工艺", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProdCraft prodCraft)
    {
        return toAjax(prodCraftService.updateProdCraft(prodCraft));
    }

    /**
     * 删除产品工艺
     */
    @PreAuthorize("@ss.hasPermi('prod:craft:remove')")
    @Log(title = "产品工艺", businessType = BusinessType.DELETE)
	@DeleteMapping("/{craftIds}")
    public AjaxResult remove(@PathVariable Long[] craftIds)
    {
        return toAjax(prodCraftService.deleteProdCraftByCraftIds(craftIds));
    }
}
