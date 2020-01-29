package de.qaware.cockroach.demo.error;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Exception mapper for {@link WebApplicationException}.
 */
@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException ex) {
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(ex.getResponse().getStatusInfo().getReasonPhrase())
                .message(ex.getMessage())
                .build();

        return Response
                .status(ex.getResponse().getStatus())
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
