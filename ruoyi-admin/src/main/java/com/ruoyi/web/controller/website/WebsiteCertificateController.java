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
import com.ruoyi.website.domain.WebsiteCertificate;
import com.ruoyi.website.service.IWebsiteCertificateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 证书信息Controller
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@RestController
@RequestMapping("/website/certificate")
public class WebsiteCertificateController extends BaseController
{
    @Autowired
    private IWebsiteCertificateService websiteCertificateService;

    /**
     * 查询证书信息列表
     */
    @PreAuthorize("@ss.hasPermi('website:certificate:list')")
    @GetMapping("/list")
    public TableDataInfo list(WebsiteCertificate websiteCertificate)
    {
        startPage();
        List<WebsiteCertificate> list = websiteCertificateService.selectWebsiteCertificateList(websiteCertificate);
        return getDataTable(list);
    }

    /**
     * 导出证书信息列表
     */
    @PreAuthorize("@ss.hasPermi('website:certificate:export')")
    @Log(title = "证书信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WebsiteCertificate websiteCertificate)
    {
        List<WebsiteCertificate> list = websiteCertificateService.selectWebsiteCertificateList(websiteCertificate);
        ExcelUtil<WebsiteCertificate> util = new ExcelUtil<WebsiteCertificate>(WebsiteCertificate.class);
        util.exportExcel(response, list, "证书信息数据");
    }

    /**
     * 获取证书信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('website:certificate:query')")
    @GetMapping(value = "/{certificateId}")
    public AjaxResult getInfo(@PathVariable("certificateId") Long certificateId)
    {
        return success(websiteCertificateService.selectWebsiteCertificateByCertificateId(certificateId));
    }

    /**
     * 新增证书信息
     */
    @PreAuthorize("@ss.hasPermi('website:certificate:add')")
    @Log(title = "证书信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WebsiteCertificate websiteCertificate)
    {
        return toAjax(websiteCertificateService.insertWebsiteCertificate(websiteCertificate));
    }

    /**
     * 修改证书信息
     */
    @PreAuthorize("@ss.hasPermi('website:certificate:edit')")
    @Log(title = "证书信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebsiteCertificate websiteCertificate)
    {
        return toAjax(websiteCertificateService.updateWebsiteCertificate(websiteCertificate));
    }

    /**
     * 删除证书信息
     */
    @PreAuthorize("@ss.hasPermi('website:certificate:remove')")
    @Log(title = "证书信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{certificateIds}")
    public AjaxResult remove(@PathVariable Long[] certificateIds)
    {
        return toAjax(websiteCertificateService.deleteWebsiteCertificateByCertificateIds(certificateIds));
    }
}
