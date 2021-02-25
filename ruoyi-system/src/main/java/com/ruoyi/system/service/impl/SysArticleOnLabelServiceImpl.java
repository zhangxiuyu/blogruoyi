package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysArticleOnLabelMapper;
import com.ruoyi.system.domain.SysArticleOnLabel;
import com.ruoyi.system.service.ISysArticleOnLabelService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章与标签关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
@Service
public class SysArticleOnLabelServiceImpl implements ISysArticleOnLabelService 
{
    @Autowired
    private SysArticleOnLabelMapper sysArticleOnLabelMapper;

    /**
     * 查询文章与标签关联
     * 
     * @param id 文章与标签关联ID
     * @return 文章与标签关联
     */
    @Override
    public SysArticleOnLabel selectSysArticleOnLabelById(String id)
    {
        return sysArticleOnLabelMapper.selectSysArticleOnLabelById(id);
    }

    /**
     * 查询文章与标签关联列表
     * 
     * @param sysArticleOnLabel 文章与标签关联
     * @return 文章与标签关联
     */
    @Override
    public List<SysArticleOnLabel> selectSysArticleOnLabelList(SysArticleOnLabel sysArticleOnLabel)
    {
        return sysArticleOnLabelMapper.selectSysArticleOnLabelList(sysArticleOnLabel);
    }

    /**
     * 新增文章与标签关联
     * 
     * @param sysArticleOnLabel 文章与标签关联
     * @return 结果
     */
    @Override
    public int insertSysArticleOnLabel(SysArticleOnLabel sysArticleOnLabel)
    {
        return sysArticleOnLabelMapper.insertSysArticleOnLabel(sysArticleOnLabel);
    }

    /**
     * 修改文章与标签关联
     * 
     * @param sysArticleOnLabel 文章与标签关联
     * @return 结果
     */
    @Override
    public int updateSysArticleOnLabel(SysArticleOnLabel sysArticleOnLabel)
    {
        return sysArticleOnLabelMapper.updateSysArticleOnLabel(sysArticleOnLabel);
    }

    /**
     * 删除文章与标签关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysArticleOnLabelByIds(String ids)
    {
        return sysArticleOnLabelMapper.deleteSysArticleOnLabelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章与标签关联信息
     * 
     * @param id 文章与标签关联ID
     * @return 结果
     */
    @Override
    public int deleteSysArticleOnLabelById(String id)
    {
        return sysArticleOnLabelMapper.deleteSysArticleOnLabelById(id);
    }
}
