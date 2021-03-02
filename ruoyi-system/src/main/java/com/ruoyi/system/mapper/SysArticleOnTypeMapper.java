package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysArticleOnType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysArticleOnTypeMapper {


    public int insertSysArticleOnType(SysArticleOnType sysArticleOnType);


    public int insertAllSysArticleOnType(@Param("array") String[] array, @Param("article_id") int article_id);


    public int deleteSysArticleOnTypeByIds(String[] ids);

    public List<SysArticleOnType> getSysArticleOnTypeIds(Integer article_id);
}
