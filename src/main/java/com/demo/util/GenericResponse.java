package com.demo.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericResponse {

    @JsonProperty
    private int httpCode;

    @JsonProperty
    private int errorCode;

    @JsonProperty
    private String message;

    public GenericResponse() {

    }

    public GenericResponse(int httpCode, int errorCode, String message) {
        super();
        this.httpCode = httpCode;
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
