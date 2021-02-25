package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysArticleLabelMapper;
import com.ruoyi.system.domain.SysArticleLabel;
import com.ruoyi.system.service.ISysArticleLabelService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章标签Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
@Service
public class SysArticleLabelServiceImpl implements ISysArticleLabelService 
{
    @Autowired
    private SysArticleLabelMapper sysArticleLabelMapper;

    /**
     * 查询文章标签
     * 
     * @param id 文章标签ID
     * @return 文章标签
     */
    @Override
    public SysArticleLabel selectSysArticleLabelById(String id)
    {
        return sysArticleLabelMapper.selectSysArticleLabelById(id);
    }

    /**
     * 查询文章标签列表
     * 
     * @param sysArticleLabel 文章标签
     * @return 文章标签
     */
    @Override
    public List<SysArticleLabel> selectSysArticleLabelList(SysArticleLabel sysArticleLabel)
    {
        return sysArticleLabelMapper.selectSysArticleLabelList(sysArticleLabel);
    }

    /**
     * 新增文章标签
     * 
     * @param sysArticleLabel 文章标签
     * @return 结果
     */
    @Override
    public int insertSysArticleLabel(SysArticleLabel sysArticleLabel)
    {
        return sysArticleLabelMapper.insertSysArticleLabel(sysArticleLabel);
    }

    /**
     * 修改文章标签
     * 
     * @param sysArticleLabel 文章标签
     * @return 结果
     */
    @Override
    public int updateSysArticleLabel(SysArticleLabel sysArticleLabel)
    {
        return sysArticleLabelMapper.updateSysArticleLabel(sysArticleLabel);
    }

    /**
     * 删除文章标签对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysArticleLabelByIds(String ids)
    {
        return sysArticleLabelMapper.deleteSysArticleLabelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章标签信息
     * 
     * @param id 文章标签ID
     * @return 结果
     */
    @Override
    public int deleteSysArticleLabelById(String id)
    {
        return sysArticleLabelMapper.deleteSysArticleLabelById(id);
    }
}
