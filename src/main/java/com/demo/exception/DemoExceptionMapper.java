package com.demo.exception;

import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;

/**
 * Te Exception mapper class.
 * 
 * @author Abhijeet
 *
 */
@Provider
public class DemoExceptionMapper implements ExceptionMapper<DemoException> {

    public Response toResponse(DemoException exception) {
        ResponseMessage resMsg = new ResponseMessage(getStatusCode(exception), exception.getMessage());
        return Response.status(resMsg.getCode()).entity(resMsg).build();
    }

    /**
     * gettng the status code
     * 
     * @param exception
     * @return
     */
    private int getStatusCode(DemoException exception) {
        int code = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        if (null != exception.getExceptionType()) {
            code = exception.getExceptionType().getCode().getStatusCode();
        }
        return code;
    }
}
