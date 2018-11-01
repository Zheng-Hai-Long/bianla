package com.bianla.admin.entity;

import java.io.Serializable;

/**
 * Created by admin on 2018/10/28.
 */
public class BFile implements Serializable {
    private Integer id;

    private String type;

    private String category;

    private String url;

    private String middleUrl;

    private String littleUrl;

    private String linkUrl;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMiddleUrl() {
        return middleUrl;
    }

    public void setMiddleUrl(String middleUrl) {
        this.middleUrl = middleUrl;
    }

    public String getLittleUrl() {
        return littleUrl;
    }

    public void setLittleUrl(String littleUrl) {
        this.littleUrl = littleUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BFile{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", url='" + url + '\'' +
                ", middleUrl='" + middleUrl + '\'' +
                ", littleUrl='" + littleUrl + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
