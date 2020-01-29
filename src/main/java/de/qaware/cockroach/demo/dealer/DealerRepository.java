package de.qaware.cockroach.demo.dealer;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional(Transactional.TxType.MANDATORY)
public interface DealerRepository extends EntityRepository<Dealer, UUID> {

}
