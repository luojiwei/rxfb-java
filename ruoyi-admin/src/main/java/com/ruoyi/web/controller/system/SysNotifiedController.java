package com.ruoyi.web.controller.system;

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
import com.ruoyi.system.domain.SysNotified;
import com.ruoyi.system.service.ISysNotifiedService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 通知信息Controller
 * 
 * @author luojiwei
 * @date 2025-06-17
 */
@RestController
@RequestMapping("/system/notified")
public class SysNotifiedController extends BaseController
{
    @Autowired
    private ISysNotifiedService sysNotifiedService;

    /**
     * 查询通知信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:notified:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysNotified sysNotified)
    {
        startPage();
        List<SysNotified> list = sysNotifiedService.selectSysNotifiedList(sysNotified);
        return getDataTable(list);
    }

    /**
     * 导出通知信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:notified:export')")
    @Log(title = "通知信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysNotified sysNotified)
    {
        List<SysNotified> list = sysNotifiedService.selectSysNotifiedList(sysNotified);
        ExcelUtil<SysNotified> util = new ExcelUtil<SysNotified>(SysNotified.class);
        util.exportExcel(response, list, "通知信息数据");
    }

    /**
     * 获取通知信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:notified:query')")
    @GetMapping(value = "/{notifiedId}")
    public AjaxResult getInfo(@PathVariable("notifiedId") Long notifiedId)
    {
        return success(sysNotifiedService.selectSysNotifiedByNotifiedId(notifiedId));
    }

    /**
     * 新增通知信息
     */
    @PreAuthorize("@ss.hasPermi('system:notified:add')")
    @Log(title = "通知信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysNotified sysNotified)
    {
        return toAjax(sysNotifiedService.insertSysNotified(sysNotified));
    }

    /**
     * 修改通知信息
     */
    @PreAuthorize("@ss.hasPermi('system:notified:edit')")
    @Log(title = "通知信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysNotified sysNotified)
    {
        return toAjax(sysNotifiedService.updateSysNotified(sysNotified));
    }

    /**
     * 删除通知信息
     */
    @PreAuthorize("@ss.hasPermi('system:notified:remove')")
    @Log(title = "通知信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{notifiedIds}")
    public AjaxResult remove(@PathVariable Long[] notifiedIds)
    {
        return toAjax(sysNotifiedService.deleteSysNotifiedByNotifiedIds(notifiedIds));
    }

    /**
     * 批量修改已读状态
     */
    @PreAuthorize("@ss.hasPermi('system:notified:edit')")
    @Log(title = "通知信息", businessType = BusinessType.UPDATE)
    @PostMapping("/batchRevise")
    public AjaxResult batchRevise(@RequestBody SysNotified sysNotified)
    {
        return toAjax(sysNotifiedService.batchReviseByNotifiedIds(sysNotified));
    }
}
