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
import com.ruoyi.system.domain.SysArticleOnType;
import com.ruoyi.system.service.ISysArticleOnTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章与类型关联Controller
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
@Controller
@RequestMapping("/system/type")
public class SysArticleOnTypeController extends BaseController
{
    private String prefix = "system/type";

    @Autowired
    private ISysArticleOnTypeService sysArticleOnTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询文章与类型关联列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysArticleOnType sysArticleOnType)
    {
        startPage();
        List<SysArticleOnType> list = sysArticleOnTypeService.selectSysArticleOnTypeList(sysArticleOnType);
        return getDataTable(list);
    }

    /**
     * 导出文章与类型关联列表
     */
    @RequiresPermissions("system:type:export")
    @Log(title = "文章与类型关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysArticleOnType sysArticleOnType)
    {
        List<SysArticleOnType> list = sysArticleOnTypeService.selectSysArticleOnTypeList(sysArticleOnType);
        ExcelUtil<SysArticleOnType> util = new ExcelUtil<SysArticleOnType>(SysArticleOnType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增文章与类型关联
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章与类型关联
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "文章与类型关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysArticleOnType sysArticleOnType)
    {
        return toAjax(sysArticleOnTypeService.insertSysArticleOnType(sysArticleOnType));
    }

    /**
     * 修改文章与类型关联
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        SysArticleOnType sysArticleOnType = sysArticleOnTypeService.selectSysArticleOnTypeById(id);
        mmap.put("sysArticleOnType", sysArticleOnType);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章与类型关联
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "文章与类型关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysArticleOnType sysArticleOnType)
    {
        return toAjax(sysArticleOnTypeService.updateSysArticleOnType(sysArticleOnType));
    }

    /**
     * 删除文章与类型关联
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "文章与类型关联", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysArticleOnTypeService.deleteSysArticleOnTypeByIds(ids));
    }
}
