package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysArticleOnLabel;
import com.ruoyi.system.mapper.SysArticleOnLabelMapper;
import com.ruoyi.system.service.ISysArticleOnLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysArticleOnLabelServiceImpl implements ISysArticleOnLabelService {


    @Autowired
    private SysArticleOnLabelMapper sysArticleOnLabelMapper;


    @Override
    public int insertSysArticleOnLabel(SysArticleOnLabel sysArticleOnLabel)
    {
        return sysArticleOnLabelMapper.insertSysArticleOnLabel(sysArticleOnLabel);
    }


    @Override
    public int insertAllSysArticleOnLabel(String[] array, int article_id){
        return sysArticleOnLabelMapper.insertAllSysArticleOnLabel(array,article_id);
    }

    @Override
    public int deleteSysArticleOnLabelByIds(String ids)
    {
        return sysArticleOnLabelMapper.deleteSysArticleOnTypeByIds(Convert.toStrArray(ids));
    }
}
