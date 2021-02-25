package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysArticleTypeMapper;
import com.ruoyi.system.domain.SysArticleType;
import com.ruoyi.system.service.ISysArticleTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
@Service
public class SysArticleTypeServiceImpl implements ISysArticleTypeService 
{
    @Autowired
    private SysArticleTypeMapper sysArticleTypeMapper;

    /**
     * 查询文章分类
     * 
     * @param id 文章分类ID
     * @return 文章分类
     */
    @Override
    public SysArticleType selectSysArticleTypeById(String id)
    {
        return sysArticleTypeMapper.selectSysArticleTypeById(id);
    }

    /**
     * 查询文章分类列表
     * 
     * @param sysArticleType 文章分类
     * @return 文章分类
     */
    @Override
    public List<SysArticleType> selectSysArticleTypeList(SysArticleType sysArticleType)
    {
        return sysArticleTypeMapper.selectSysArticleTypeList(sysArticleType);
    }

    /**
     * 新增文章分类
     * 
     * @param sysArticleType 文章分类
     * @return 结果
     */
    @Override
    public int insertSysArticleType(SysArticleType sysArticleType)
    {
        return sysArticleTypeMapper.insertSysArticleType(sysArticleType);
    }

    /**
     * 修改文章分类
     * 
     * @param sysArticleType 文章分类
     * @return 结果
     */
    @Override
    public int updateSysArticleType(SysArticleType sysArticleType)
    {
        return sysArticleTypeMapper.updateSysArticleType(sysArticleType);
    }

    /**
     * 删除文章分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysArticleTypeByIds(String ids)
    {
        return sysArticleTypeMapper.deleteSysArticleTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章分类信息
     * 
     * @param id 文章分类ID
     * @return 结果
     */
    @Override
    public int deleteSysArticleTypeById(String id)
    {
        return sysArticleTypeMapper.deleteSysArticleTypeById(id);
    }
}
