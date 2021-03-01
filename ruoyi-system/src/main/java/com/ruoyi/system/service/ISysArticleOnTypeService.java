package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysArticleOnType;


public interface ISysArticleOnTypeService {



    /**
     * 新增
     *
     * @param sysArticleLabel 文章标签
     * @return 结果
     */
    public int insertSysArticleOnType(SysArticleOnType sysArticleLabel);


    public int insertAllSysArticleOnType(String[] array, int article_id);

}
