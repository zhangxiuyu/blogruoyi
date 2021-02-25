package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysArticle;

/**
 * 文章Service接口
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
public interface ISysArticleService 
{
    /**
     * 查询文章
     * 
     * @param id 文章ID
     * @return 文章
     */
    public SysArticle selectSysArticleById(String id);

    /**
     * 查询文章列表
     * 
     * @param sysArticle 文章
     * @return 文章集合
     */
    public List<SysArticle> selectSysArticleList(SysArticle sysArticle);

    /**
     * 新增文章
     * 
     * @param sysArticle 文章
     * @return 结果
     */
    public int insertSysArticle(SysArticle sysArticle);

    /**
     * 修改文章
     * 
     * @param sysArticle 文章
     * @return 结果
     */
    public int updateSysArticle(SysArticle sysArticle);

    /**
     * 批量删除文章
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysArticleByIds(String ids);

    /**
     * 删除文章信息
     * 
     * @param id 文章ID
     * @return 结果
     */
    public int deleteSysArticleById(String id);
}
