package com.ruoyi.web.controller.website;

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
import com.ruoyi.website.domain.WebsiteHonor;
import com.ruoyi.website.service.IWebsiteHonorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 荣誉信息Controller
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@RestController
@RequestMapping("/website/honor")
public class WebsiteHonorController extends BaseController
{
    @Autowired
    private IWebsiteHonorService websiteHonorService;

    /**
     * 查询荣誉信息列表
     */
    @PreAuthorize("@ss.hasPermi('website:honor:list')")
    @GetMapping("/list")
    public TableDataInfo list(WebsiteHonor websiteHonor)
    {
        startPage();
        List<WebsiteHonor> list = websiteHonorService.selectWebsiteHonorList(websiteHonor);
        return getDataTable(list);
    }

    /**
     * 导出荣誉信息列表
     */
    @PreAuthorize("@ss.hasPermi('website:honor:export')")
    @Log(title = "荣誉信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WebsiteHonor websiteHonor)
    {
        List<WebsiteHonor> list = websiteHonorService.selectWebsiteHonorList(websiteHonor);
        ExcelUtil<WebsiteHonor> util = new ExcelUtil<WebsiteHonor>(WebsiteHonor.class);
        util.exportExcel(response, list, "荣誉信息数据");
    }

    /**
     * 获取荣誉信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('website:honor:query')")
    @GetMapping(value = "/{honorId}")
    public AjaxResult getInfo(@PathVariable("honorId") Long honorId)
    {
        return success(websiteHonorService.selectWebsiteHonorByHonorId(honorId));
    }

    /**
     * 新增荣誉信息
     */
    @PreAuthorize("@ss.hasPermi('website:honor:add')")
    @Log(title = "荣誉信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WebsiteHonor websiteHonor)
    {
        return toAjax(websiteHonorService.insertWebsiteHonor(websiteHonor));
    }

    /**
     * 修改荣誉信息
     */
    @PreAuthorize("@ss.hasPermi('website:honor:edit')")
    @Log(title = "荣誉信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebsiteHonor websiteHonor)
    {
        return toAjax(websiteHonorService.updateWebsiteHonor(websiteHonor));
    }

    /**
     * 删除荣誉信息
     */
    @PreAuthorize("@ss.hasPermi('website:honor:remove')")
    @Log(title = "荣誉信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{honorIds}")
    public AjaxResult remove(@PathVariable Long[] honorIds)
    {
        return toAjax(websiteHonorService.deleteWebsiteHonorByHonorIds(honorIds));
    }
}
