package com.project.aliya.model.content;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ModelVideo {
    @SerializedName("id")
    private Integer idVideo;
    private String url;
    private String title;
    private String descriptions;
    @SerializedName("dateCreated")
    private String date_created;
    @SerializedName("dateModified")
    private String date_modified;
    @SerializedName("layout_id")
    private String layoutId;
}
