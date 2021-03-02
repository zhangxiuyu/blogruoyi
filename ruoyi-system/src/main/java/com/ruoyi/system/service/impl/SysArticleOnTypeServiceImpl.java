package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysArticleOnType;
import com.ruoyi.system.mapper.SysArticleOnTypeMapper;
import com.ruoyi.system.service.ISysArticleOnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysArticleOnTypeServiceImpl implements ISysArticleOnTypeService {

    @Autowired
    private SysArticleOnTypeMapper sysArticleOnTypeMapper;


    /**
     * 新增单个
     * @param sysArticleOnType
     * @return
     */
    @Override
    public int insertSysArticleOnType(SysArticleOnType sysArticleOnType){
        return sysArticleOnTypeMapper.insertSysArticleOnType(sysArticleOnType);
    }


    /**
     * 插入多个关联
     * @param array
     * @param article_id
     * @return
     */
    @Override
    public int insertAllSysArticleOnType(String[] array, int article_id){
        return sysArticleOnTypeMapper.insertAllSysArticleOnType(array, article_id);
    }

    /**
     * 删除多类型关联
     * @param ids
     * @return
     */
    @Override
    public int deleteSysArticleOnTypeByIds(String ids){
        return sysArticleOnTypeMapper.deleteSysArticleOnTypeByIds(Convert.toStrArray(ids));
    }


}
