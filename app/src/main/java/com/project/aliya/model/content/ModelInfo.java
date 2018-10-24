package com.project.aliya.model.content;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by faizf on 7/11/2017.
 */
@Data
public class ModelInfo {
    @SerializedName("id")
    private Integer idInfo;
    private String title;
    private String content;
    @SerializedName("for_ebook")
    private String forEbook;
    @SerializedName("date_created")
    private String dateCreated;
    @SerializedName("date_modified")
    private Object dateModified;
    @SerializedName("status")
    private Integer status;
    @SerializedName("content_preview")
    private String contentPreview;
    @SerializedName("status_read")
    private String statusRead;
    private String image;

}
