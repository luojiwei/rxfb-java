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
import com.ruoyi.website.domain.WebsitePartner;
import com.ruoyi.website.service.IWebsitePartnerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 伙伴信息Controller
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@RestController
@RequestMapping("/website/partner")
public class WebsitePartnerController extends BaseController
{
    @Autowired
    private IWebsitePartnerService websitePartnerService;

    /**
     * 查询伙伴信息列表
     */
    @PreAuthorize("@ss.hasPermi('website:partner:list')")
    @GetMapping("/list")
    public TableDataInfo list(WebsitePartner websitePartner)
    {
        startPage();
        List<WebsitePartner> list = websitePartnerService.selectWebsitePartnerList(websitePartner);
        return getDataTable(list);
    }

    /**
     * 导出伙伴信息列表
     */
    @PreAuthorize("@ss.hasPermi('website:partner:export')")
    @Log(title = "伙伴信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WebsitePartner websitePartner)
    {
        List<WebsitePartner> list = websitePartnerService.selectWebsitePartnerList(websitePartner);
        ExcelUtil<WebsitePartner> util = new ExcelUtil<WebsitePartner>(WebsitePartner.class);
        util.exportExcel(response, list, "伙伴信息数据");
    }

    /**
     * 获取伙伴信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('website:partner:query')")
    @GetMapping(value = "/{partnerId}")
    public AjaxResult getInfo(@PathVariable("partnerId") Long partnerId)
    {
        return success(websitePartnerService.selectWebsitePartnerByPartnerId(partnerId));
    }

    /**
     * 新增伙伴信息
     */
    @PreAuthorize("@ss.hasPermi('website:partner:add')")
    @Log(title = "伙伴信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WebsitePartner websitePartner)
    {
        return toAjax(websitePartnerService.insertWebsitePartner(websitePartner));
    }

    /**
     * 修改伙伴信息
     */
    @PreAuthorize("@ss.hasPermi('website:partner:edit')")
    @Log(title = "伙伴信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebsitePartner websitePartner)
    {
        return toAjax(websitePartnerService.updateWebsitePartner(websitePartner));
    }

    /**
     * 删除伙伴信息
     */
    @PreAuthorize("@ss.hasPermi('website:partner:remove')")
    @Log(title = "伙伴信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{partnerIds}")
    public AjaxResult remove(@PathVariable Long[] partnerIds)
    {
        return toAjax(websitePartnerService.deleteWebsitePartnerByPartnerIds(partnerIds));
    }
}
