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
import com.ruoyi.website.domain.WebsiteContact;
import com.ruoyi.website.service.IWebsiteContactService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 官网留言Controller
 * 
 * @author luojiwei
 * @date 2025-06-25
 */
@RestController
@RequestMapping("/website/contact")
public class WebsiteContactController extends BaseController
{
    @Autowired
    private IWebsiteContactService websiteContactService;

    /**
     * 查询官网留言列表
     */
    @PreAuthorize("@ss.hasPermi('website:contact:list')")
    @GetMapping("/list")
    public TableDataInfo list(WebsiteContact websiteContact)
    {
        startPage();
        List<WebsiteContact> list = websiteContactService.selectWebsiteContactList(websiteContact);
        return getDataTable(list);
    }

    /**
     * 导出官网留言列表
     */
    @PreAuthorize("@ss.hasPermi('website:contact:export')")
    @Log(title = "官网留言", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WebsiteContact websiteContact)
    {
        List<WebsiteContact> list = websiteContactService.selectWebsiteContactList(websiteContact);
        ExcelUtil<WebsiteContact> util = new ExcelUtil<WebsiteContact>(WebsiteContact.class);
        util.exportExcel(response, list, "官网留言数据");
    }

    /**
     * 获取官网留言详细信息
     */
    @PreAuthorize("@ss.hasPermi('website:contact:query')")
    @GetMapping(value = "/{contactId}")
    public AjaxResult getInfo(@PathVariable("contactId") Long contactId)
    {
        return success(websiteContactService.selectWebsiteContactByContactId(contactId));
    }

    /**
     * 新增官网留言
     */
    @PreAuthorize("@ss.hasPermi('website:contact:add')")
    @Log(title = "官网留言", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WebsiteContact websiteContact)
    {
        return toAjax(websiteContactService.insertWebsiteContact(websiteContact));
    }

    /**
     * 修改官网留言
     */
    @PreAuthorize("@ss.hasPermi('website:contact:edit')")
    @Log(title = "官网留言", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebsiteContact websiteContact)
    {
        return toAjax(websiteContactService.updateWebsiteContact(websiteContact));
    }

    /**
     * 删除官网留言
     */
    @PreAuthorize("@ss.hasPermi('website:contact:remove')")
    @Log(title = "官网留言", businessType = BusinessType.DELETE)
	@DeleteMapping("/{contactIds}")
    public AjaxResult remove(@PathVariable Long[] contactIds)
    {
        return toAjax(websiteContactService.deleteWebsiteContactByContactIds(contactIds));
    }
}
