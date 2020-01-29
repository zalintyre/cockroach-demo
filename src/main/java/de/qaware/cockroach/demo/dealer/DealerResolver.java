package de.qaware.cockroach.demo.dealer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class DealerResolver {

    @Inject
    private DealerRepository dealerRepository;

    public Dealer resolve(UUID dealerId) {
        Optional<Dealer> storedEntity = dealerRepository.findOptionalBy(dealerId);
        if (storedEntity.isPresent()) {
            return storedEntity.get();
        } else {
            throw new WebApplicationException("Entity " + dealerId + " was not found in the database for type Car.", Response.Status.BAD_REQUEST);
        }
    }
}
