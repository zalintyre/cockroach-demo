package de.qaware.cockroach.demo.dealer;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Slf4j
@Transactional
@Path("dealer")
@ApplicationScoped
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class DealerResource {

    @Inject
    private DealerRepository dealerRepository;

    @GET
    public Response getDealers() {
        LOGGER.info("Retrieving all dealers...");

        List<Dealer> dealers = dealerRepository.findAll();

        return Response.ok(dealers).build();
    }

    @POST
    public Response addDealer(Dealer dealer) {
        LOGGER.info("Adding dealer {}.", dealer);

        dealerRepository.save(dealer);

        return Response.ok().build();
    }

}
