package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysArticleOnLabel;

/**
 * 文章与标签关联Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
public interface SysArticleOnLabelMapper 
{
    /**
     * 查询文章与标签关联
     * 
     * @param id 文章与标签关联ID
     * @return 文章与标签关联
     */
    public SysArticleOnLabel selectSysArticleOnLabelById(String id);

    /**
     * 查询文章与标签关联列表
     * 
     * @param sysArticleOnLabel 文章与标签关联
     * @return 文章与标签关联集合
     */
    public List<SysArticleOnLabel> selectSysArticleOnLabelList(SysArticleOnLabel sysArticleOnLabel);

    /**
     * 新增文章与标签关联
     * 
     * @param sysArticleOnLabel 文章与标签关联
     * @return 结果
     */
    public int insertSysArticleOnLabel(SysArticleOnLabel sysArticleOnLabel);

    /**
     * 修改文章与标签关联
     * 
     * @param sysArticleOnLabel 文章与标签关联
     * @return 结果
     */
    public int updateSysArticleOnLabel(SysArticleOnLabel sysArticleOnLabel);

    /**
     * 删除文章与标签关联
     * 
     * @param id 文章与标签关联ID
     * @return 结果
     */
    public int deleteSysArticleOnLabelById(String id);

    /**
     * 批量删除文章与标签关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysArticleOnLabelByIds(String[] ids);
}
