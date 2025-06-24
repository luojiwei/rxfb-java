package com.ruoyi.prod.controller;

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
import com.ruoyi.prod.domain.ProdTask;
import com.ruoyi.prod.service.IProdTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 生产任务Controller
 * 
 * @author luojiwei
 * @date 2025-06-21
 */
@RestController
@RequestMapping("/prod/task")
public class ProdTaskController extends BaseController
{
    @Autowired
    private IProdTaskService prodTaskService;

    /**
     * 查询生产任务列表
     */
    @PreAuthorize("@ss.hasPermi('prod:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProdTask prodTask)
    {
        startPage();
        List<ProdTask> list = prodTaskService.selectProdTaskList(prodTask);
        return getDataTable(list);
    }

    /**
     * 导出生产任务列表
     */
    @PreAuthorize("@ss.hasPermi('prod:task:export')")
    @Log(title = "生产任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProdTask prodTask)
    {
        List<ProdTask> list = prodTaskService.selectProdTaskList(prodTask);
        ExcelUtil<ProdTask> util = new ExcelUtil<ProdTask>(ProdTask.class);
        util.exportExcel(response, list, "生产任务数据");
    }

    /**
     * 获取生产任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('prod:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(prodTaskService.selectProdTaskByTaskId(taskId));
    }

    /**
     * 新增生产任务
     */
    @PreAuthorize("@ss.hasPermi('prod:task:add')")
    @Log(title = "生产任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProdTask prodTask)
    {
        return toAjax(prodTaskService.insertProdTask(prodTask));
    }

    /**
     * 修改生产任务
     */
    @PreAuthorize("@ss.hasPermi('prod:task:edit')")
    @Log(title = "生产任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProdTask prodTask)
    {
        return toAjax(prodTaskService.updateProdTask(prodTask));
    }

    /**
     * 删除生产任务
     */
    @PreAuthorize("@ss.hasPermi('prod:task:remove')")
    @Log(title = "生产任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(prodTaskService.deleteProdTaskByTaskIds(taskIds));
    }
}
