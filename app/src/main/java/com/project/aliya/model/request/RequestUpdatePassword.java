package com.project.aliya.model.request;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by DELL on 8/24/2017.
 */
@Data
public class RequestUpdatePassword {
    @SerializedName("password_lama")
    private String passwordLama;
    @SerializedName("password_baru")
    private String passwordBaru;
    @SerializedName("password_baru_konfirm")
    private String passwordBaruKonfirm;
}
