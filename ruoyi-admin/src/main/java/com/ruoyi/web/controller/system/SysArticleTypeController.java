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
import com.ruoyi.system.domain.SysArticleType;
import com.ruoyi.system.service.ISysArticleTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章分类Controller
 * 
 * @author ruoyi
 * @date 2021-02-26
 */
@Controller
@RequestMapping("/system/type")
public class SysArticleTypeController extends BaseController
{
    private String prefix = "system/type";

    @Autowired
    private ISysArticleTypeService sysArticleTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询文章分类列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysArticleType sysArticleType)
    {
        startPage();
        List<SysArticleType> list = sysArticleTypeService.selectSysArticleTypeList(sysArticleType);
        return getDataTable(list);
    }

    /**
     * 导出文章分类列表
     */
    @RequiresPermissions("system:type:export")
    @Log(title = "文章分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysArticleType sysArticleType)
    {
        List<SysArticleType> list = sysArticleTypeService.selectSysArticleTypeList(sysArticleType);
        ExcelUtil<SysArticleType> util = new ExcelUtil<SysArticleType>(SysArticleType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增文章分类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章分类
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "文章分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysArticleType sysArticleType)
    {
        return toAjax(sysArticleTypeService.insertSysArticleType(sysArticleType));
    }

    /**
     * 修改文章分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        SysArticleType sysArticleType = sysArticleTypeService.selectSysArticleTypeById(id);
        mmap.put("sysArticleType", sysArticleType);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章分类
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "文章分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysArticleType sysArticleType)
    {
        return toAjax(sysArticleTypeService.updateSysArticleType(sysArticleType));
    }

    /**
     * 删除文章分类
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "文章分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysArticleTypeService.deleteSysArticleTypeByIds(ids));
    }
}
