package com.ruoyi.web.controller.website;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.website.domain.WebsiteHome;
import com.ruoyi.website.service.IWebsiteHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 官网信息Controller
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@RestController
@RequestMapping("/website/home")
public class WebsiteHomeController extends BaseController
{
    @Autowired
    private IWebsiteHomeService websiteHomeService;

    /**
     * 获取官网信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('website:home:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(websiteHomeService.selectWebsiteHomeById(id));
    }

    /**
     * 修改官网信息
     */
    @PreAuthorize("@ss.hasPermi('website:home:edit')")
    @Log(title = "官网信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebsiteHome websiteHome)
    {
        return toAjax(websiteHomeService.updateWebsiteHome(websiteHome));
    }
}
