package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysArticleOnType;

import java.util.List;


public interface ISysArticleOnTypeService {


    /**
     * 新增文章类型 增加一条
     * @param sysArticleOnType
     * @return
     */
    public int insertSysArticleOnType(SysArticleOnType sysArticleOnType);


    /**
     * 新增文章与类型绑定关系   增加多条
     * @param array
     * @param article_id
     * @return
     */
    public int insertAllSysArticleOnType(String[] array, int article_id);


    public int deleteSysArticleOnTypeByIds(String ids);



    public List<SysArticleOnType> getSysArticleOnTypeIds(Integer article_id);

}
