package com.demo.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Exception type for the application.
 * 
 * @author Abhijeet
 *
 */
public enum ExceptionType {

    VALIDATION_EXCEPTION(Response.Status.PRECONDITION_FAILED),

    DATA_NOT_FOUND(Response.Status.NOT_FOUND),

    INVALID_DATA(Response.Status.CONFLICT),

    INVALID_REQUEST(Response.Status.BAD_REQUEST);

    private Status code;

    ExceptionType(Status code) {
        this.code = code;
    }

    public Status getCode() {
        return code;
    }

}