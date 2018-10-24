package com.project.aliya.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseResponse<E> implements Serializable {
    private String path;
    private String message;
    private E data;
    @SerializedName("last_page")
    private int lastPage;
    @SerializedName("current_page")
    private int currentPage;
}
