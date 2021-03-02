package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.SysArticleLabel;
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
public class SysArticleController extends BaseController
{
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
    public String article()
    {
        return prefix + "/article";
    }

    /**
     * 查询文章列表
     */
    @RequiresPermissions("system:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysArticle sysArticle)
    {
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
    public AjaxResult export(SysArticle sysArticle)
    {
        List<SysArticle> list = sysArticleService.selectSysArticleList(sysArticle);
        ExcelUtil<SysArticle> util = new ExcelUtil<SysArticle>(SysArticle.class);
        return util.exportExcel(list, "article");
    }

    /**
     * 新增文章
     */
    @GetMapping("/add")
    public String add(ModelMap mmap,SysArticleType sysArticleType,SysArticleLabel sysArticleLabel)
    {
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
    public AjaxResult addSave(HttpServletRequest request, SysArticle sysArticle)
    {
        String[] types = request.getParameterValues("type");
        String[] labels = request.getParameterValues("label");

        int st = sysArticleService.insertSysArticle(sysArticle);
        // 成功的插入 类型 还有标签
        if (st == 1){
            // 类型
            sysArticleOnTypeService.insertAllSysArticleOnType(types,sysArticle.getId());
            // 标签
            sysArticleOnLabelService.insertAllSysArticleOnLabel(labels,sysArticle.getId());
        }
        return toAjax(st);
    }

    /**
     * 修改文章
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap,SysArticleType sysArticleType,SysArticleLabel sysArticleLabel)
    {
        SysArticle sysArticle = sysArticleService.selectSysArticleById(id);

        // 类型
        List<SysArticleType> typeList = sysArticleTypeService.selectSysArticleTypeList(sysArticleType);
        // 标签
        List<SysArticleLabel> labelList = sysArticleLabelService.selectSysArticleLabelList(sysArticleLabel);

        mmap.put("sysArticle", sysArticle);
        mmap.put("sysArticleType", typeList);
        mmap.put("sysArticleLabel", labelList);


        System.out.print(mmap);


        return prefix + "/edit";
    }

    /**
     * 修改保存文章
     */
    @RequiresPermissions("system:article:edit")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysArticle sysArticle)
    {
        return toAjax(sysArticleService.updateSysArticle(sysArticle));
    }

    /**
     * 删除文章
     */
    @RequiresPermissions("system:article:remove")
    @Log(title = "文章", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysArticleService.deleteSysArticleByIds(ids));
    }
}
