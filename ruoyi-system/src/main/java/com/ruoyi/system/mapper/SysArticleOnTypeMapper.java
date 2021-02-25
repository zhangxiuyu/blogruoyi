package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysArticleOnType;

/**
 * 文章与类型关联Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
public interface SysArticleOnTypeMapper 
{
    /**
     * 查询文章与类型关联
     * 
     * @param id 文章与类型关联ID
     * @return 文章与类型关联
     */
    public SysArticleOnType selectSysArticleOnTypeById(String id);

    /**
     * 查询文章与类型关联列表
     * 
     * @param sysArticleOnType 文章与类型关联
     * @return 文章与类型关联集合
     */
    public List<SysArticleOnType> selectSysArticleOnTypeList(SysArticleOnType sysArticleOnType);

    /**
     * 新增文章与类型关联
     * 
     * @param sysArticleOnType 文章与类型关联
     * @return 结果
     */
    public int insertSysArticleOnType(SysArticleOnType sysArticleOnType);

    /**
     * 修改文章与类型关联
     * 
     * @param sysArticleOnType 文章与类型关联
     * @return 结果
     */
    public int updateSysArticleOnType(SysArticleOnType sysArticleOnType);

    /**
     * 删除文章与类型关联
     * 
     * @param id 文章与类型关联ID
     * @return 结果
     */
    public int deleteSysArticleOnTypeById(String id);

    /**
     * 批量删除文章与类型关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysArticleOnTypeByIds(String[] ids);
}
