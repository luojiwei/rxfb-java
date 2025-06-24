package com.ruoyi.web.controller.external;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.prod.domain.ProdCategory;
import com.ruoyi.prod.domain.ProdProduct;
import com.ruoyi.prod.domain.vo.ProductQueryVo;
import com.ruoyi.prod.service.IProdCategoryService;
import com.ruoyi.prod.service.IProdProductService;
import com.ruoyi.website.domain.*;
import com.ruoyi.website.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/external")
public class WebsiteController extends BaseController {
    @Autowired
    private IWebsiteHomeService websiteHomeService;

    @GetMapping(value = "/getHomeData/{id}")
    public AjaxResult getHomeData(@PathVariable("id") Long id) {
        return success(websiteHomeService.selectWebsiteHomeById(id));
    }

    @Autowired
    private IWebsiteBannerService websiteBannerService;

    @GetMapping("/getBannerList")
    public TableDataInfo getBannerList(WebsiteBanner banner) {
        startPage();
        List<WebsiteBanner> list = websiteBannerService.selectWebsiteBannerList(banner);
        return getDataTable(list);
    }

    @Autowired
    private IWebsiteCertificateService websiteCertificateService;

    @GetMapping("/getCertificateList")
    public TableDataInfo getCertificateList(WebsiteCertificate certificate) {
        startPage();
        List<WebsiteCertificate> list = websiteCertificateService.selectWebsiteCertificateList(certificate);
        return getDataTable(list);
    }

    @Autowired
    private IWebsiteHonorService websiteHonorService;

    @GetMapping("/getHonorList")
    public TableDataInfo getHonorList(WebsiteHonor honor) {
        startPage();
        List<WebsiteHonor> list = websiteHonorService.selectWebsiteHonorList(honor);
        return getDataTable(list);
    }

    @Autowired
    private IWebsitePartnerService websitePartnerService;

    @GetMapping("/getPartnerList")
    public TableDataInfo getPartnerList(WebsitePartner partner) {
        startPage();
        List<WebsitePartner> list = websitePartnerService.selectWebsitePartnerList(partner);
        return getDataTable(list);
    }

    @Autowired
    private IWebsiteNewsService websiteNewsService;

    @GetMapping("/getNewsList")
    public TableDataInfo getNewsList(WebsiteNews news) {
        startPage();
        List<WebsiteNews> list = websiteNewsService.selectWebsiteNewsList(news);
        return getDataTable(list);
    }

    @GetMapping(value = "/getNewsDetails/{id}")
    public AjaxResult getNewsDetails(@PathVariable("id") Long id) {
        return success(websiteNewsService.selectWebsiteNewsByNewsId(id));
    }

    @Autowired
    private IWebsiteProductService websiteProductService;

    @GetMapping("/getProductPosition")
    public TableDataInfo getProductPosition(WebsiteProduct websiteProduct) {
        startPage();
        List<WebsiteProduct> list = websiteProductService.selectWebsiteProductList(websiteProduct);
        return getDataTable(list);
    }

    @Autowired
    private IProdCategoryService prodCategoryService;

    @GetMapping("/getCategoryList")
    public TableDataInfo getCategoryList(ProdCategory prodCategory) {
        startPage();
        List<ProdCategory> list = prodCategoryService.selectProdCategoryList(prodCategory);
        return getDataTable(list);
    }

    @Autowired
    private IProdProductService prodProductService;

    @GetMapping("/getProductList")
    public TableDataInfo getProductList(ProductQueryVo queryVo) {
        startPage();
        List<ProdProduct> list = prodProductService.selectProdProductList(queryVo);
        return getDataTable(list);
    }

}
