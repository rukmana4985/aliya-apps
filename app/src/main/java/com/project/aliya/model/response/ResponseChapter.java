package com.project.aliya.model.response;

import com.google.gson.annotations.SerializedName;
import com.project.aliya.model.BaseResponse;

import lombok.Data;

/**
 * Created by DELL on 8/24/2017.
 */
@Data

public class ResponseChapter extends BaseResponse<ResponseChapter> {
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
    @SerializedName("description")
    private String description;
    @SerializedName("parent_id")
    private Integer parentId;
    @SerializedName("layout_id")
    private String layoutId;
    @SerializedName("sorting")
    private Integer sorting;
    @SerializedName("page_url")
    private String pageUrl;
}
