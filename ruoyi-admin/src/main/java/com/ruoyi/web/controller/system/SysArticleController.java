package com.ruoyi.web.controller.system;

import java.util.Arrays;
import java.util.List;

import com.ruoyi.system.domain.SysArticleLabel;
import com.ruoyi.system.domain.SysArticleOnType;
import com.ruoyi.system.domain.SysArticleType;
import com.ruoyi.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysArticle;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 文章Controller
 *
 * @author ruoyi
 * @date 2021-02-26
 */
@Controller
@RequestMapping("/system/article")
public class SysArticleController extends BaseController {
    private String prefix = "system/article";

    @Autowired
    private ISysArticleService sysArticleService;

    @Autowired
    private ISysArticleTypeService sysArticleTypeService;

    @Autowired
    private ISysArticleLabelService sysArticleLabelService;

    @Autowired
    private ISysArticleOnTypeService sysArticleOnTypeService;


    @Autowired
    private ISysArticleOnLabelService sysArticleOnLabelService;


    @RequiresPermissions("system:article:view")
    @GetMapping()
    public String article() {
        return prefix + "/article";
    }

    /**
     * 查询文章列表
     */
    @RequiresPermissions("system:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysArticle sysArticle) {
        startPage();
        List<SysArticle> list = sysArticleService.selectSysArticleList(sysArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章列表
     */
    @RequiresPermissions("system:article:export")
    @Log(title = "文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysArticle sysArticle) {
        List<SysArticle> list = sysArticleService.selectSysArticleList(sysArticle);
        ExcelUtil<SysArticle> util = new ExcelUtil<SysArticle>(SysArticle.class);
        return util.exportExcel(list, "article");
    }

    /**
     * 新增文章
     */
    @GetMapping("/add")
    public String add(ModelMap mmap, SysArticleType sysArticleType, SysArticleLabel sysArticleLabel) {
        // 类型
        List<SysArticleType> typeList = sysArticleTypeService.selectSysArticleTypeList(sysArticleType);
        // 标签
        List<SysArticleLabel> labelList = sysArticleLabelService.selectSysArticleLabelList(sysArticleLabel);

        mmap.put("sysArticleType", typeList);
        mmap.put("sysArticleLabel", labelList);

        return prefix + "/add";
    }

    /**
     * 新增保存文章
     */
    @RequiresPermissions("system:article:add")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HttpServletRequest request, SysArticle sysArticle) {
        String[] types = request.getParameterValues("type");
        String[] labels = request.getParameterValues("label");

        int st = sysArticleService.insertSysArticle(sysArticle);
        // 成功的插入 类型 还有标签
        if (st == 1) {
            // 类型
            sysArticleOnTypeService.insertAllSysArticleOnType(types, sysArticle.getId());
            // 标签
            sysArticleOnLabelService.insertAllSysArticleOnLabel(labels, sysArticle.getId());
        }
        return toAjax(st);
    }

    /**
     * 修改文章
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap, SysArticleType sysArticleType, SysArticleLabel sysArticleLabel) {
        SysArticle sysArticle = sysArticleService.selectSysArticleById(id);

        // 类型
        List<SysArticleType> typeList = sysArticleTypeService.selectSysArticleTypeList(sysArticleType);
        // 查这个文章的关联
        List<SysArticleOnType> typeIds = sysArticleOnTypeService.getSysArticleOnTypeIds(id);

        // 标签
        List<SysArticleLabel> labelList = sysArticleLabelService.selectSysArticleLabelList(sysArticleLabel);


        System.out.println(typeIds);
        System.out.println("--------------");

        typeList.forEach((type) -> {
            // 获取所有的关联sql中的type_ids
            System.out.println("type_id=" + type.getId());
            System.out.println("============");
            System.out.println("isCheck=" + typeIds.stream().anyMatch(task -> task.getTypeId().equals(type.getId())));
//            System.out.println("============");
//            System.out.println("article_id=" + id);
        });

        mmap.put("sysArticle", sysArticle);
        mmap.put("sysArticleType", typeList);
        mmap.put("sysArticleLabel", labelList);

//        System.out.print(mmap);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章
     */
    @RequiresPermissions("system:article:edit")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysArticle sysArticle, HttpServletRequest request) {
        // 先删除后插入
        String ids = String.valueOf(sysArticle.getId());
        sysArticleOnTypeService.deleteSysArticleOnTypeByIds(ids);
        sysArticleOnLabelService.deleteSysArticleOnLabelByIds(ids);

        // 插入修改的
        String[] types = request.getParameterValues("type");
        String[] labels = request.getParameterValues("label");
        System.out.println(Arrays.toString(types));
        System.out.println("2222222222222222222222");
        System.out.println(Arrays.toString(labels));

        int st = sysArticleService.updateSysArticle(sysArticle);
        // 成功的插入 类型 还有标签
        if (st == 1) {
            // 类型
            sysArticleOnTypeService.insertAllSysArticleOnType(types, sysArticle.getId());
            // 标签
            sysArticleOnLabelService.insertAllSysArticleOnLabel(labels, sysArticle.getId());
        }

        return toAjax(st);
    }

    /**
     * 删除文章
     */
    @RequiresPermissions("system:article:remove")
    @Log(title = "文章", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        int st = sysArticleService.deleteSysArticleByIds(ids);

        // 删除成功后， 删除文章与标签 类型关联表数据
        if (st == 1) {
            sysArticleOnTypeService.deleteSysArticleOnTypeByIds(ids);
            sysArticleOnLabelService.deleteSysArticleOnLabelByIds(ids);
        }
        return toAjax(st);
    }
}
