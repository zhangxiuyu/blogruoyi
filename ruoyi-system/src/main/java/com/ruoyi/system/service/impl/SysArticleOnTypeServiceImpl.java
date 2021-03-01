package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysArticleOnType;
import com.ruoyi.system.mapper.SysArticleOnTypeMapper;
import com.ruoyi.system.service.ISysArticleOnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysArticleOnTypeServiceImpl implements ISysArticleOnTypeService {

    @Autowired
    private SysArticleOnTypeMapper sysArticleOnTypeMapper;


    @Override
    public int insertSysArticleOnType(SysArticleOnType sysArticleOnType){
        return sysArticleOnTypeMapper.insertSysArticleOnType(sysArticleOnType);
    }


    @Override
    public int insertAllSysArticleOnType(String[] array, int article_id){
        return sysArticleOnTypeMapper.insertAllSysArticleOnType(array, article_id);
    }



}
