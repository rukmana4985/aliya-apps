package com.project.aliya.model.request;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RequestLogin {
    public String username;
    public String password;
    @SerializedName("device_id")
    public String deviceId;
    public String layout;
}
