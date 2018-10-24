package com.project.aliya.model.response;

import com.google.gson.annotations.SerializedName;
import com.project.aliya.model.BaseResponse;
import com.project.aliya.model.content.ModelVideo;

import lombok.Data;

/**
 * Created by DELL on 8/24/2017.
 */
@Data

public class ResponseListVideo extends BaseResponse<ModelVideo[]> {

}
