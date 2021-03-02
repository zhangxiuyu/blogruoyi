package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysArticleOnLabel;
import org.apache.ibatis.annotations.Param;

public interface SysArticleOnLabelMapper {


    public int insertSysArticleOnLabel(SysArticleOnLabel sysArticleOnLabel);


    public int insertAllSysArticleOnLabel(@Param("array") String[] array, @Param("article_id") int article_id);

    public int deleteSysArticleOnTypeByIds(String[] ids);
}
