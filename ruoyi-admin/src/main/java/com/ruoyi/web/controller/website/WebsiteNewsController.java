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
import com.ruoyi.website.domain.WebsiteNews;
import com.ruoyi.website.service.IWebsiteNewsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻信息Controller
 * 
 * @author luojiwei
 * @date 2025-06-13
 */
@RestController
@RequestMapping("/website/news")
public class WebsiteNewsController extends BaseController
{
    @Autowired
    private IWebsiteNewsService websiteNewsService;

    /**
     * 查询新闻信息列表
     */
    @PreAuthorize("@ss.hasPermi('website:news:list')")
    @GetMapping("/list")
    public TableDataInfo list(WebsiteNews websiteNews)
    {
        startPage();
        List<WebsiteNews> list = websiteNewsService.selectWebsiteNewsList(websiteNews);
        return getDataTable(list);
    }

    /**
     * 查询新闻信息列表
     */
    @PreAuthorize("@ss.hasPermi('website:news:search')")
    @GetMapping("/search")
    public AjaxResult search(WebsiteNews websiteNews) {
        return success(websiteNewsService.searchNewsList(websiteNews));
    }

    /**
     * 导出新闻信息列表
     */
    @PreAuthorize("@ss.hasPermi('website:news:export')")
    @Log(title = "新闻信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WebsiteNews websiteNews)
    {
        List<WebsiteNews> list = websiteNewsService.selectWebsiteNewsList(websiteNews);
        ExcelUtil<WebsiteNews> util = new ExcelUtil<WebsiteNews>(WebsiteNews.class);
        util.exportExcel(response, list, "新闻信息数据");
    }

    /**
     * 获取新闻信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('website:news:query')")
    @GetMapping(value = "/{newsId}")
    public AjaxResult getInfo(@PathVariable("newsId") Long newsId)
    {
        return success(websiteNewsService.selectWebsiteNewsByNewsId(newsId));
    }

    /**
     * 新增新闻信息
     */
    @PreAuthorize("@ss.hasPermi('website:news:add')")
    @Log(title = "新闻信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WebsiteNews websiteNews)
    {
        return toAjax(websiteNewsService.insertWebsiteNews(websiteNews));
    }

    /**
     * 修改新闻信息
     */
    @PreAuthorize("@ss.hasPermi('website:news:edit')")
    @Log(title = "新闻信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebsiteNews websiteNews)
    {
        return toAjax(websiteNewsService.updateWebsiteNews(websiteNews));
    }

    /**
     * 删除新闻信息
     */
    @PreAuthorize("@ss.hasPermi('website:news:remove')")
    @Log(title = "新闻信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{newsIds}")
    public AjaxResult remove(@PathVariable Long[] newsIds)
    {
        return toAjax(websiteNewsService.deleteWebsiteNewsByNewsIds(newsIds));
    }
}
