package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysArticleOnLabel;

public interface ISysArticleOnLabelService {


    /**
     *
     * @param sysArticleOnLabel
     * @return
     */
    public int insertSysArticleOnLabel(SysArticleOnLabel sysArticleOnLabel);


    /**
     *
     * @param array
     * @param article_id
     * @return
     */
    public int insertAllSysArticleOnLabel(String[] array, int article_id);


}
