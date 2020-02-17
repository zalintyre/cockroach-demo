package de.qaware.cockroach.demo.dealer;

import de.qaware.cockroach.demo.car.Car;
import org.apache.deltaspike.data.api.EntityCountRepository;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional(Transactional.TxType.MANDATORY)
public interface DealerRepository extends EntityRepository<Dealer, UUID>, EntityCountRepository<Dealer>, CriteriaSupport<Car> {

    @Query("SELECT COUNT(c) FROM Car c\n" +
        "WHERE c.dealer.name LIKE 'Roger %'")
    long getCarCountForDealersNamedRoger();

    @Query(value = "SELECT c.dealer.name, COUNT(c) as carcount FROM Car c\n" +
        "WHERE c.brand = ?1\n" +
        "GROUP BY c.brand, c.dealer.id, c.dealer.name\n" +
        "ORDER BY carcount DESC", max = 5)
    List<Tuple> getDealersWithMostCarsOfBrand(String brand);
}
