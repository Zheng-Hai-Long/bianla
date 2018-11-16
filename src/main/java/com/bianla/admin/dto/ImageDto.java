package com.bianla.admin.dto;

/**
 * Created by ZHL on 2018/11/16.
 */
public class ImageDTO {

    private Integer imageId;

    private String imageUrl;

    public ImageDTO(Integer imageId, String imageUrl) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
