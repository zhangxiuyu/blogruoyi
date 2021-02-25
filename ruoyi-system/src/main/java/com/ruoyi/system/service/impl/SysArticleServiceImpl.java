package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysArticleMapper;
import com.ruoyi.system.domain.SysArticle;
import com.ruoyi.system.service.ISysArticleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
@Service
public class SysArticleServiceImpl implements ISysArticleService 
{
    @Autowired
    private SysArticleMapper sysArticleMapper;

    /**
     * 查询文章
     * 
     * @param id 文章ID
     * @return 文章
     */
    @Override
    public SysArticle selectSysArticleById(String id)
    {
        return sysArticleMapper.selectSysArticleById(id);
    }

    /**
     * 查询文章列表
     * 
     * @param sysArticle 文章
     * @return 文章
     */
    @Override
    public List<SysArticle> selectSysArticleList(SysArticle sysArticle)
    {
        return sysArticleMapper.selectSysArticleList(sysArticle);
    }

    /**
     * 新增文章
     * 
     * @param sysArticle 文章
     * @return 结果
     */
    @Override
    public int insertSysArticle(SysArticle sysArticle)
    {
        return sysArticleMapper.insertSysArticle(sysArticle);
    }

    /**
     * 修改文章
     * 
     * @param sysArticle 文章
     * @return 结果
     */
    @Override
    public int updateSysArticle(SysArticle sysArticle)
    {
        return sysArticleMapper.updateSysArticle(sysArticle);
    }

    /**
     * 删除文章对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysArticleByIds(String ids)
    {
        return sysArticleMapper.deleteSysArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章信息
     * 
     * @param id 文章ID
     * @return 结果
     */
    @Override
    public int deleteSysArticleById(String id)
    {
        return sysArticleMapper.deleteSysArticleById(id);
    }
}
