package de.qaware.cockroach.demo.error;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * This exception mapper catches all Exceptions not caught elsewhere.
 * It will log them and return a HTTP 500 status code.
 */
@Provider
@Slf4j
public class DefaultExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable ex) {
        final ErrorResponse errorResponse = ErrorResponse.builder().errorCode(Response.Status.INTERNAL_SERVER_ERROR.name()).build();

        LOGGER.error("Uncaught exception: {}", errorResponse, ex);

        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
