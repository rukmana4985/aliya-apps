package com.project.aliya.model.response;

import com.project.aliya.model.content.ModelEbookPremium;

import lombok.Data;

/**
 * Created by DELL on 8/24/2017.
 */
@Data
public class ResponseLogin {
    private String token;
    private ModelEbookPremium data;
}
