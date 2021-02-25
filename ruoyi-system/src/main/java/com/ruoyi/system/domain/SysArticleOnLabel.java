package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章与标签关联对象 sys_article_on_label
 * 
 * @author ruoyi
 * @date 2021-02-25
 */
public class SysArticleOnLabel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 标签id */
    @Excel(name = "标签id")
    private Long labelId;

    /** 文章id */
    @Excel(name = "文章id")
    private Long articleId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setLabelId(Long labelId) 
    {
        this.labelId = labelId;
    }

    public Long getLabelId() 
    {
        return labelId;
    }
    public void setArticleId(Long articleId) 
    {
        this.articleId = articleId;
    }

    public Long getArticleId() 
    {
        return articleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("labelId", getLabelId())
            .append("articleId", getArticleId())
            .toString();
    }
}
