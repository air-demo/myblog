package com.air.myblog.quervo;

/**
 * 搜索博客管理列表
 * @author air
 * @create 2020-10-29-17:26
 */
public class SearchBlog {

    private Long typeId;
    private String title;
    private boolean recommend;

    public SearchBlog() {
    }


    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }


    @Override
    public String toString() {
        return "SearchBlog{" +
                "typeId=" + typeId +
                ", title='" + title + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}