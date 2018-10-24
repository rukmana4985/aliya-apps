package com.project.aliya.utils;

import java.io.Serializable;

public class SliderCustom implements Serializable {

    private int id;
    private String imageUrl;
    private int imageCorner;
    private String description;

    public SliderCustom(int id, String imageUrl,int imageCorner, String description) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.imageCorner = imageCorner;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageCorner() {
        return imageCorner;
    }

    public void setImageCorner(int imageCorner) {
        this.imageCorner = imageCorner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}