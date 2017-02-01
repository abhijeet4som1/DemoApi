package com.demo.exception;

/**
 * Response message object to handle exception and return proper message.
 * 
 * @author Abhijeet
 *
 */
public class ResponseMessage {

    private int code;

    private String message;

    public ResponseMessage(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
