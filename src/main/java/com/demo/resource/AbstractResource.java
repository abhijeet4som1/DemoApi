package com.demo.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import com.demo.util.GenericResponse;

public abstract class AbstractResource {

    protected abstract Logger getLogger();

    protected abstract String getPath();

    protected boolean isSuccess(Response response) {
        int status = response.getStatus();
        return (status >= 200 && status < 300);
    }

    protected Response ok(String message) {
        int okCode = Response.Status.OK.getStatusCode();
        return Response.ok(new GenericResponse(okCode, okCode, message)).build();
    }

    protected Response ok(Object object) {
        return Response.ok(object).build();
    }

    protected Response ok() {
        return Response.ok().build();
    }

    protected Response ok(Object object, NewCookie... cookies) {
        return Response.ok(object).cookie(cookies).build();
    }

    protected Response bad(GenericResponse response) {
        int httpCode = Response.Status.BAD_REQUEST.getStatusCode();
        response.setHttpCode(httpCode);
        getLogger().error("Error processing request code:{}, message:{}", httpCode, response.getMessage());
        return Response.status(httpCode).entity(response).build();
    }

    protected Response bad(int errorCode, String message) {
        int httpCode = Response.Status.BAD_REQUEST.getStatusCode();
        getLogger().error("Error processing request code:{}, message:{}", errorCode, message);
        return Response.status(httpCode).entity(new GenericResponse(httpCode, errorCode, message)).build();
    }

    protected Response error(GenericResponse response) {
        int httpCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        response.setHttpCode(httpCode);
        getLogger().error("Error processing request code:{}, message:{}", httpCode, response.getMessage());
        return Response.status(httpCode).entity(response).build();
    }

    protected Response error(int errorCode, String message) {
        int httpCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        getLogger().error("Error processing request code:{}, message:{}", errorCode, message);
        return Response.status(errorCode).entity(new GenericResponse(httpCode, errorCode, message)).build();
    }

    protected Response created(Object object, Object id) {
        try {
            return Response.created(new URI(getPath() + "/" + String.valueOf(id))).entity(object).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    protected Response notFound() {
        int notFound = Response.Status.NOT_FOUND.getStatusCode();
        String message = "Requested resource not found";
        getLogger().error("Error processing request code:{}, message:{}", notFound, message);
        return Response.status(notFound).entity(new GenericResponse(notFound, notFound, message)).build();
    }

    protected Response deleted() {
        return Response.noContent().build();
    }

    protected Response unauthorized(GenericResponse response) {
        int httpCode = Response.Status.UNAUTHORIZED.getStatusCode();
        response.setHttpCode(httpCode);
        getLogger().error("Error processing request code:{}, message:{}", httpCode,
                response.getMessage() + " for base path " + getPath());
        return Response.status(httpCode).entity(response).build();
    }

    protected Response unauthorized(int errorCode, String message) {
        int httpCode = Response.Status.UNAUTHORIZED.getStatusCode();
        getLogger().error("Error processing request code:{}, message:{}", httpCode,
                message + " for base path " + getPath());
        return Response.status(httpCode).entity(new GenericResponse(httpCode, errorCode, message)).build();
    }
}