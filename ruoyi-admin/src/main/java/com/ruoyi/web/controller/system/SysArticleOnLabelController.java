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
import com.ruoyi.system.domain.SysArticleOnLabel;
import com.ruoyi.system.service.ISysArticleOnLabelService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章与标签关联Controller
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
@Controller
@RequestMapping("/system/label")
public class SysArticleOnLabelController extends BaseController
{
    private String prefix = "system/label";

    @Autowired
    private ISysArticleOnLabelService sysArticleOnLabelService;

    @RequiresPermissions("system:label:view")
    @GetMapping()
    public String label()
    {
        return prefix + "/label";
    }

    /**
     * 查询文章与标签关联列表
     */
    @RequiresPermissions("system:label:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysArticleOnLabel sysArticleOnLabel)
    {
        startPage();
        List<SysArticleOnLabel> list = sysArticleOnLabelService.selectSysArticleOnLabelList(sysArticleOnLabel);
        return getDataTable(list);
    }

    /**
     * 导出文章与标签关联列表
     */
    @RequiresPermissions("system:label:export")
    @Log(title = "文章与标签关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysArticleOnLabel sysArticleOnLabel)
    {
        List<SysArticleOnLabel> list = sysArticleOnLabelService.selectSysArticleOnLabelList(sysArticleOnLabel);
        ExcelUtil<SysArticleOnLabel> util = new ExcelUtil<SysArticleOnLabel>(SysArticleOnLabel.class);
        return util.exportExcel(list, "label");
    }

    /**
     * 新增文章与标签关联
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章与标签关联
     */
    @RequiresPermissions("system:label:add")
    @Log(title = "文章与标签关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysArticleOnLabel sysArticleOnLabel)
    {
        return toAjax(sysArticleOnLabelService.insertSysArticleOnLabel(sysArticleOnLabel));
    }

    /**
     * 修改文章与标签关联
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        SysArticleOnLabel sysArticleOnLabel = sysArticleOnLabelService.selectSysArticleOnLabelById(id);
        mmap.put("sysArticleOnLabel", sysArticleOnLabel);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章与标签关联
     */
    @RequiresPermissions("system:label:edit")
    @Log(title = "文章与标签关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysArticleOnLabel sysArticleOnLabel)
    {
        return toAjax(sysArticleOnLabelService.updateSysArticleOnLabel(sysArticleOnLabel));
    }

    /**
     * 删除文章与标签关联
     */
    @RequiresPermissions("system:label:remove")
    @Log(title = "文章与标签关联", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysArticleOnLabelService.deleteSysArticleOnLabelByIds(ids));
    }
}
