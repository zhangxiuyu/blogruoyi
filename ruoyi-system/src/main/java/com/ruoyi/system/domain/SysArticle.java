package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章对象 sys_article
 * 
 * @author ruoyi
 * @date 2021-02-26
 */
public class SysArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章id */
    private Integer id;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 文章简介 */
    @Excel(name = "文章简介")
    private String brief;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String con;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    /** 置顶 */
    @Excel(name = "置顶")
    private Integer top;

    /** 状态 */
    @Excel(name = "状态")
    private Integer state;

    /** 观看数量 */
    @Excel(name = "观看数量")
    private Long showNum;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
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
    public void setBrief(String brief) 
    {
        this.brief = brief;
    }

    public String getBrief() 
    {
        return brief;
    }
    public void setCon(String con) 
    {
        this.con = con;
    }

    public String getCon() 
    {
        return con;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }
    public void setTop(Integer top) 
    {
        this.top = top;
    }

    public Integer getTop() 
    {
        return top;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }
    public void setShowNum(Long showNum) 
    {
        this.showNum = showNum;
    }

    public Long getShowNum() 
    {
        return showNum;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("brief", getBrief())
            .append("con", getCon())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .append("top", getTop())
            .append("state", getState())
            .append("showNum", getShowNum())
            .append("sort", getSort())
            .toString();
    }
}
