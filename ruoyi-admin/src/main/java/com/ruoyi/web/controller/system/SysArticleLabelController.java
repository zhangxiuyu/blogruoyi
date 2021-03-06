package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.system.domain.SysArticleLabel;
import com.ruoyi.system.service.ISysArticleLabelService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章标签Controller
 * 
 * @author ruoyi
 * @date 2021-02-26
 */
@Controller
@RequestMapping("/system/label")
public class SysArticleLabelController extends BaseController
{
    private String prefix = "system/label";

    @Autowired
    private ISysArticleLabelService sysArticleLabelService;

    @RequiresPermissions("system:label:view")
    @GetMapping()
    public String label()
    {
        return prefix + "/label";
    }

    /**
     * 查询文章标签列表
     */
    @RequiresPermissions("system:label:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysArticleLabel sysArticleLabel)
    {
        startPage();
        List<SysArticleLabel> list = sysArticleLabelService.selectSysArticleLabelList(sysArticleLabel);
        return getDataTable(list);
    }

    /**
     * 导出文章标签列表
     */
    @RequiresPermissions("system:label:export")
    @Log(title = "文章标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysArticleLabel sysArticleLabel)
    {
        List<SysArticleLabel> list = sysArticleLabelService.selectSysArticleLabelList(sysArticleLabel);
        ExcelUtil<SysArticleLabel> util = new ExcelUtil<SysArticleLabel>(SysArticleLabel.class);
        return util.exportExcel(list, "label");
    }

    /**
     * 新增文章标签
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章标签
     */
    @RequiresPermissions("system:label:add")
    @Log(title = "文章标签", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysArticleLabel sysArticleLabel)
    {
        return toAjax(sysArticleLabelService.insertSysArticleLabel(sysArticleLabel));
    }

    /**
     * 修改文章标签
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        SysArticleLabel sysArticleLabel = sysArticleLabelService.selectSysArticleLabelById(id);
        mmap.put("sysArticleLabel", sysArticleLabel);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章标签
     */
    @RequiresPermissions("system:label:edit")
    @Log(title = "文章标签", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysArticleLabel sysArticleLabel)
    {
        return toAjax(sysArticleLabelService.updateSysArticleLabel(sysArticleLabel));
    }

    /**
     * 删除文章标签
     */
    @RequiresPermissions("system:label:remove")
    @Log(title = "文章标签", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysArticleLabelService.deleteSysArticleLabelByIds(ids));
    }
}
