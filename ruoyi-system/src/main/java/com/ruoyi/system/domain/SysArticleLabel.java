package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章标签对象 sys_article_label
 * 
 * @author ruoyi
 * @date 2021-02-26
 */
public class SysArticleLabel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String id;

    /** 是否选中  true**/
    private boolean check_id;

    /** 名称 */
    @Excel(name = "名称")
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

    public boolean isCheck_id() {
        return check_id;
    }

    public void setCheck_id(boolean check_id) {
        this.check_id = check_id;
    }

    @Override
    public String toString() {
        return "SysArticleLabel{" +
                "id='" + id + '\'' +
                ", check_id=" + check_id +
                ", title='" + title + '\'' +
                '}';
    }
}
