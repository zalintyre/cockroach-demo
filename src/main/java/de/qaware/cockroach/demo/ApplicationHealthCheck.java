package de.qaware.cockroach.demo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;

/**
 * Called by the orchestration framework to check if application is reachable and alive.
 */
@Health
@ApplicationScoped
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class ApplicationHealthCheck implements HealthCheck {

    /**
     * Always returns true if the application has enough resources to answer.
     *
     * @return the response
     */
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("application").up().build();
    }
}
