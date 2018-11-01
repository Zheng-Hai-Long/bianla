package com.bianla.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2018/10/28.
 */
public class News implements Serializable{

    private Integer id;

    private String title;

    private String source;

    private String abstracts;

    private String content;

    private Integer categoryId;

    private Integer coverimageId;

    private Date update_time;

    private Date create_time;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCoverimageId() {
        return coverimageId;
    }

    public void setCoverimageId(Integer coverimageId) {
        this.coverimageId = coverimageId;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", abstracts='" + abstracts + '\'' +
                ", content='" + content + '\'' +
                ", categoryId=" + categoryId +
                ", coverimageId=" + coverimageId +
                ", update_time=" + update_time +
                ", create_time=" + create_time +
                '}';
    }
}
