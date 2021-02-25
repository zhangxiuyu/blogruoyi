package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysArticleType;

/**
 * 文章分类Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
public interface SysArticleTypeMapper 
{
    /**
     * 查询文章分类
     * 
     * @param id 文章分类ID
     * @return 文章分类
     */
    public SysArticleType selectSysArticleTypeById(String id);

    /**
     * 查询文章分类列表
     * 
     * @param sysArticleType 文章分类
     * @return 文章分类集合
     */
    public List<SysArticleType> selectSysArticleTypeList(SysArticleType sysArticleType);

    /**
     * 新增文章分类
     * 
     * @param sysArticleType 文章分类
     * @return 结果
     */
    public int insertSysArticleType(SysArticleType sysArticleType);

    /**
     * 修改文章分类
     * 
     * @param sysArticleType 文章分类
     * @return 结果
     */
    public int updateSysArticleType(SysArticleType sysArticleType);

    /**
     * 删除文章分类
     * 
     * @param id 文章分类ID
     * @return 结果
     */
    public int deleteSysArticleTypeById(String id);

    /**
     * 批量删除文章分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysArticleTypeByIds(String[] ids);
}
