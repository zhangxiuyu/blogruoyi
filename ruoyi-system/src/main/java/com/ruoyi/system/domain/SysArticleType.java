package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章分类对象 sys_article_type
 * 
 * @author ruoyi
 * @date 2021-02-26
 */
public class SysArticleType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String id;

    /** 是否选中 **/
    private boolean check_id;

    public boolean isCheck_id() {
        return check_id;
    }

    public void setCheck_id(boolean check_id) {
        this.check_id = check_id;
    }

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() {
        return "SysArticleType{" +
                "id='" + id + '\'' +
                ", check_id=" + check_id +
                ", title='" + title + '\'' +
                '}';
    }
}
