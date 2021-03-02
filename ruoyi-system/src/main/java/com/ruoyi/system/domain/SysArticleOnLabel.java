package com.ruoyi.system.domain;

public class SysArticleOnLabel {

    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String id;


    /** 类型id */
    private String labelId;


    /** 文章id */
    private String articleId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getLabelId() {
        return labelId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLabelId(String typeId) {
        this.labelId = typeId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }


    @Override
    public String toString() {
        return "SysArticleOnLabel{" +
                "id='" + id + '\'' +
                ", labelId='" + labelId + '\'' +
                ", articleId='" + articleId + '\'' +
                '}';
    }
}
