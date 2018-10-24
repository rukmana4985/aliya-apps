package com.project.aliya.model.response;

import com.google.gson.annotations.SerializedName;
import com.project.aliya.model.BaseResponse;
import com.project.aliya.model.content.ModelInfo;

import lombok.Data;

/**
 * Created by My Computer on 11/10/2017.
 */

@Data
public class ResponseListInfo extends BaseResponse<ModelInfo[]> {

}
