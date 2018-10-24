package com.project.aliya.model.content;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by faizf on 7/11/2017.
 */
@Data
public class ModelEbookDetail {
    @SerializedName("id")
    private Integer id;
    @SerializedName("hd_id")
    private Integer EbookId;
    @SerializedName("name")
    private String name;
    @SerializedName("page_start")
    private Integer pageStart;
    @SerializedName("page_end")
    private Integer pageEnd;
    @SerializedName("status")
    private Integer status;
    @SerializedName("date_created")
    private String dateCreated;
    @SerializedName("date_modified")
    private Object dateModified;

}
