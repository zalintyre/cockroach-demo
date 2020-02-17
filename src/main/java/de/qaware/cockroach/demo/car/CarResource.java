package de.qaware.cockroach.demo.car;

import de.qaware.cockroach.demo.integration.StatisticsController;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Slf4j
@Path("car")
@Transactional
@ApplicationScoped
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class CarResource {

    @Inject
    private CarController carController;

    @Inject
    private StatisticsController statisticsController;

    @GET
    @Path("dealer/{dealerId}")
    public Response getCarsByDealer(@PathParam("dealerId") UUID dealerId) {
        LOGGER.info("Retrieving all cars for dealer {} ...", dealerId);

        List<CarDto> cars = carController.getCarsByDealer(dealerId);

        return Response.ok(cars).build();
    }

    @GET
    @Path("statistics/{brand}")
    public Response getStatistics(@PathParam("brand") String brand) {
        LOGGER.info("Retrieving statistics");

        Map<String, Object> statistics = statisticsController.getStatisticsForBrand(brand);

        return Response.ok(statistics).build();
    }

    @POST
    public Response addCar(CarDto car) {
        LOGGER.info("Adding car {}.", car);

        car.setId(UUID.randomUUID());
        CarDto storedCar = carController.storeCar(car);

        return Response.ok(storedCar).build();
    }

}
