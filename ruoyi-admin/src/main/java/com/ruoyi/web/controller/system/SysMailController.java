package com.ruoyi.web.controller.system;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysMail;
import com.ruoyi.system.service.ISysMailService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 邮件信息Controller
 * 
 * @author luojiwei
 * @date 2025-06-15
 */
@RestController
@RequestMapping("/system/mail")
public class SysMailController extends BaseController
{
    @Autowired
    private ISysMailService sysMailService;

    /**
     * 查询邮件信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:mail:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysMail sysMail)
    {
        startPage();
        List<SysMail> list = sysMailService.selectSysMailList(sysMail);
        return getDataTable(list);
    }

    /**
     * 获取邮件信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:mail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysMailService.selectSysMailById(id));
    }

    /**
     * 发送邮件
     */
    @PreAuthorize("@ss.hasPermi('system:mail:add')")
    @Log(title = "邮件信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysMail sysMail)
    {
        return toAjax(sysMailService.insertSysMail(sysMail));
    }

    /**
     * 查询用户发送的邮件列表
     */
    @PreAuthorize("@ss.hasPermi('system:mail:list')")
    @GetMapping("/sentList")
    public TableDataInfo sentList(Long userId)
    {
        startPage();
        List<SysMail> list = sysMailService.selectSentMailsByUserId(userId);
        return getDataTable(list);
    }

    /**
     * 查询用户接收的邮件列表
     */
    @PreAuthorize("@ss.hasPermi('system:mail:list')")
    @GetMapping("/receivedList")
    public TableDataInfo receivedList(Long userId)
    {
        startPage();
        List<SysMail> list = sysMailService.selectReceivedMailsByUserId(userId);
        return getDataTable(list);
    }
}
