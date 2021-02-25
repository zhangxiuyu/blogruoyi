package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysArticleOnTypeMapper;
import com.ruoyi.system.domain.SysArticleOnType;
import com.ruoyi.system.service.ISysArticleOnTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章与类型关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
@Service
public class SysArticleOnTypeServiceImpl implements ISysArticleOnTypeService 
{
    @Autowired
    private SysArticleOnTypeMapper sysArticleOnTypeMapper;

    /**
     * 查询文章与类型关联
     * 
     * @param id 文章与类型关联ID
     * @return 文章与类型关联
     */
    @Override
    public SysArticleOnType selectSysArticleOnTypeById(String id)
    {
        return sysArticleOnTypeMapper.selectSysArticleOnTypeById(id);
    }

    /**
     * 查询文章与类型关联列表
     * 
     * @param sysArticleOnType 文章与类型关联
     * @return 文章与类型关联
     */
    @Override
    public List<SysArticleOnType> selectSysArticleOnTypeList(SysArticleOnType sysArticleOnType)
    {
        return sysArticleOnTypeMapper.selectSysArticleOnTypeList(sysArticleOnType);
    }

    /**
     * 新增文章与类型关联
     * 
     * @param sysArticleOnType 文章与类型关联
     * @return 结果
     */
    @Override
    public int insertSysArticleOnType(SysArticleOnType sysArticleOnType)
    {
        return sysArticleOnTypeMapper.insertSysArticleOnType(sysArticleOnType);
    }

    /**
     * 修改文章与类型关联
     * 
     * @param sysArticleOnType 文章与类型关联
     * @return 结果
     */
    @Override
    public int updateSysArticleOnType(SysArticleOnType sysArticleOnType)
    {
        return sysArticleOnTypeMapper.updateSysArticleOnType(sysArticleOnType);
    }

    /**
     * 删除文章与类型关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysArticleOnTypeByIds(String ids)
    {
        return sysArticleOnTypeMapper.deleteSysArticleOnTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章与类型关联信息
     * 
     * @param id 文章与类型关联ID
     * @return 结果
     */
    @Override
    public int deleteSysArticleOnTypeById(String id)
    {
        return sysArticleOnTypeMapper.deleteSysArticleOnTypeById(id);
    }
}
