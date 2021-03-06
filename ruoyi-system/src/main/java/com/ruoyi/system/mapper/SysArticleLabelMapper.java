package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysArticleLabel;

/**
 * 文章标签Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-26
 */
public interface SysArticleLabelMapper 
{
    /**
     * 查询文章标签
     * 
     * @param id 文章标签ID
     * @return 文章标签
     */
    public SysArticleLabel selectSysArticleLabelById(String id);

    /**
     * 查询文章标签列表
     * 
     * @param sysArticleLabel 文章标签
     * @return 文章标签集合
     */
    public List<SysArticleLabel> selectSysArticleLabelList(SysArticleLabel sysArticleLabel);

    /**
     * 新增文章标签
     * 
     * @param sysArticleLabel 文章标签
     * @return 结果
     */
    public int insertSysArticleLabel(SysArticleLabel sysArticleLabel);

    /**
     * 修改文章标签
     * 
     * @param sysArticleLabel 文章标签
     * @return 结果
     */
    public int updateSysArticleLabel(SysArticleLabel sysArticleLabel);

    /**
     * 删除文章标签
     * 
     * @param id 文章标签ID
     * @return 结果
     */
    public int deleteSysArticleLabelById(String id);

    /**
     * 批量删除文章标签
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysArticleLabelByIds(String[] ids);
}
