package de.qaware.cockroach.demo.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Standard error response body
 */
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public final class ErrorResponse {
    private String errorCode;
    private String message;
    @Builder.Default
    private String traceId = UUID.randomUUID().toString();
}
