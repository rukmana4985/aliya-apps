package com.project.aliya.model.response;

import com.google.gson.annotations.SerializedName;
import com.project.aliya.model.BaseResponse;

import lombok.Data;

/**
 * Created by DELL on 8/24/2017.
 */
@Data

public class ResponseListBonus extends BaseResponse<ResponseListBonus[]> {
    @SerializedName("id")
    private Integer idBonus;
    private String url;
    private String title;
    private String image;
    private String descriptions;
    @SerializedName("dateCreated")
    private String date_created;
    @SerializedName("dateModified")
    private String date_modified;
    @SerializedName("layout_id")
    private String layoutId;
}
