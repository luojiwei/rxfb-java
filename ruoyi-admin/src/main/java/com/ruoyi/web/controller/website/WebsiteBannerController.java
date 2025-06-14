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
import com.ruoyi.website.domain.WebsiteBanner;
import com.ruoyi.website.service.IWebsiteBannerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * Banner信息Controller
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@RestController
@RequestMapping("/website/banner")
public class WebsiteBannerController extends BaseController
{
    @Autowired
    private IWebsiteBannerService websiteBannerService;

    /**
     * 查询Banner信息列表
     */
    @PreAuthorize("@ss.hasPermi('website:banner:list')")
    @GetMapping("/list")
    public TableDataInfo list(WebsiteBanner websiteBanner)
    {
        startPage();
        List<WebsiteBanner> list = websiteBannerService.selectWebsiteBannerList(websiteBanner);
        return getDataTable(list);
    }

    /**
     * 导出Banner信息列表
     */
    @PreAuthorize("@ss.hasPermi('website:banner:export')")
    @Log(title = "Banner信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WebsiteBanner websiteBanner)
    {
        List<WebsiteBanner> list = websiteBannerService.selectWebsiteBannerList(websiteBanner);
        ExcelUtil<WebsiteBanner> util = new ExcelUtil<WebsiteBanner>(WebsiteBanner.class);
        util.exportExcel(response, list, "Banner信息数据");
    }

    /**
     * 获取Banner信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('website:banner:query')")
    @GetMapping(value = "/{bannerId}")
    public AjaxResult getInfo(@PathVariable("bannerId") Long bannerId)
    {
        return success(websiteBannerService.selectWebsiteBannerByBannerId(bannerId));
    }

    /**
     * 新增Banner信息
     */
    @PreAuthorize("@ss.hasPermi('website:banner:add')")
    @Log(title = "Banner信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WebsiteBanner websiteBanner)
    {
        return toAjax(websiteBannerService.insertWebsiteBanner(websiteBanner));
    }

    /**
     * 修改Banner信息
     */
    @PreAuthorize("@ss.hasPermi('website:banner:edit')")
    @Log(title = "Banner信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebsiteBanner websiteBanner)
    {
        return toAjax(websiteBannerService.updateWebsiteBanner(websiteBanner));
    }

    /**
     * 删除Banner信息
     */
    @PreAuthorize("@ss.hasPermi('website:banner:remove')")
    @Log(title = "Banner信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bannerIds}")
    public AjaxResult remove(@PathVariable Long[] bannerIds)
    {
        return toAjax(websiteBannerService.deleteWebsiteBannerByBannerIds(bannerIds));
    }
}
