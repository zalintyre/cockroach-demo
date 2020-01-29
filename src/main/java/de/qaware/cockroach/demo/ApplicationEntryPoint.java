package de.qaware.cockroach.demo;

import de.qaware.cockroach.demo.car.CarResource;
import de.qaware.cockroach.demo.dealer.DealerResource;
import de.qaware.cockroach.demo.error.ConstraintViolationExceptionMapper;
import de.qaware.cockroach.demo.error.DefaultExceptionMapper;
import de.qaware.cockroach.demo.error.WebApplicationExceptionMapper;
import de.qaware.cockroach.demo.integration.EntityManagerProducer;
import lombok.NoArgsConstructor;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Entry point
 */
@ApplicationPath("api")
@NoArgsConstructor
public class ApplicationEntryPoint extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(EntityManagerProducer.class);

        // Error handling
        classes.add(ConstraintViolationExceptionMapper.class);
        classes.add(DefaultExceptionMapper.class);
        classes.add(WebApplicationExceptionMapper.class);

        classes.add(CarResource.class);
        classes.add(DealerResource.class);

        return classes;
    }
}
