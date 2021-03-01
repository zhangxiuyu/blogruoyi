package com.ruoyi.system.domain;

public class SysArticleOnType {

    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String id;


    /** 类型id */
    private String typeId;


    /** 文章id */
    private String articleId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "SysArticleOnType{" +
                "id='" + id + '\'' +
                ", typeId='" + typeId + '\'' +
                ", articleId='" + articleId + '\'' +
                '}';
    }
}
