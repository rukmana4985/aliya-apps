package com.project.aliya.model;

import lombok.Data;

@Data
public class ModelError {
    private String timestamp;
    private int status;
    private String[] errors;
    private String message;
    private String path;
}
