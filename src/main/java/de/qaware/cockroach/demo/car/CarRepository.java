package de.qaware.cockroach.demo.car;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional(Transactional.TxType.MANDATORY)
public interface CarRepository extends EntityRepository<Car, UUID> {

    @Query(value = "SELECT c FROM Car c " +
        "WHERE c.dealer.id = ?1")
    List<Car> getCarsByDealer(UUID dealerId);

}
