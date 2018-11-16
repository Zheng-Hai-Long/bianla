package com.bianla.admin.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZHL on 2018/11/16.
 */
public class NewsDTO implements Serializable{

    private Integer id;

    private String title;

    private String source;

    private String abstracts;

    private String content;

    private String categoryName;

    private Integer coverimageId;

    private String coverimageUrl;

    /**
     * 新闻状态
     * 100：草稿
     * 200：发布中
     * 300：隐藏
     */
    private Integer state;

    private Date updateTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCoverimageId() {
        return coverimageId;
    }

    public void setCoverimageId(Integer coverimageId) {
        this.coverimageId = coverimageId;
    }

    public String getCoverimageUrl() {
        return coverimageUrl;
    }

    public void setCoverimageUrl(String coverimageUrl) {
        this.coverimageUrl = coverimageUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
