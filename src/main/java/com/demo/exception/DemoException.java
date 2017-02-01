package com.demo.exception;

/**
 * Exception class for the application.
 * 
 * @author Abhijeet
 *
 */
public class DemoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;

    private final ExceptionType exceptionType;

    public DemoException(Exception e) {
        super(e);
        this.message = null;
        this.exceptionType = null;
    }

    public DemoException(Throwable e) {
        super(e);
        this.message = null;
        this.exceptionType = null;
    }

    public DemoException(String message) {
        super(message);
        this.message = message;
        this.exceptionType = null;
    }

    public DemoException(String message, ExceptionType exceptionType) {
        super(message);
        this.message = message;
        this.exceptionType = exceptionType;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }
}