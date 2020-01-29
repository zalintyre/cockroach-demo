package de.qaware.cockroach.demo.integration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * The CDI producer bean for the entity manager.
 */
@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceUnit
    private EntityManagerFactory emf;

    /**
     * Creates a new EntityManager.
     *
     * @return an instance of {@link EntityManager}.
     */
    @Produces
    @RequestScoped
    public EntityManager create() {
        return emf.createEntityManager();
    }

    /**
     * Closes the EntityManager.
     *
     * @param em the EntityManager to close.
     */
    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}