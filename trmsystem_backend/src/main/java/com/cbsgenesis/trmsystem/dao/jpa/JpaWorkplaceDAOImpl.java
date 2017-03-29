package com.cbsgenesis.trmsystem.dao.jpa;

import com.cbsgenesis.trmsystem.dao.WorkplaceDAO;
import com.cbsgenesis.trmsystem.model.Workplace;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.UUID;

/**
 * Implementation of {@link WorkplaceDAO} interface.
 *
 * @author Iryna Seliutina.
 */

@Repository
public class JpaWorkplaceDAOImpl implements WorkplaceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final static Logger logger = Logger.getLogger(JpaWorkplaceDAOImpl.class);

    @Override
    public void save(Workplace entity) {
        if (entity.getId()== null){
            this.entityManager.persist(entity);
            logger.info("Workplace successfully saved. Workplace details: " + entity);
        } else {
            this.entityManager.merge(entity);
            logger.info("Workplace successfully updated. Workplace details: " + entity);
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public Workplace getById(UUID uuid) {
        Query query = this.entityManager.createQuery(
                "SELECT DISTINCT workplace FROM Workplace workplace LEFT JOIN FETCH workplace.specialists" +
                        "WHERE workplace.id = :id");
        query.setParameter("id", uuid);
        Workplace workplace = (Workplace) query.getSingleResult();

        logger.info("Workplace successfully loaded. Workplace details: " + workplace);

        return workplace;
    }

    @Override
    public Collection<Workplace> getAll() {
        Collection<Workplace> result;
        Query query = this.entityManager.createQuery("SELECT workplace FROM Workplace workplace");
        result = query.getResultList();

        for(Workplace workplace: result) {
            logger.info("Workplace list: " + workplace);
        }
        return result;
    }

    @Override
    public void delete(Workplace entity) {
        this.entityManager.remove(entity);
        logger.info("Workplace successfully removed. Details: " + entity);

    }

    @Override
    public Workplace findByName(String name) {
        try {
            Query query = this.entityManager.createQuery("FROM Workplace workplace workplace.name=:name", Workplace.class);
            query.setParameter("name", name);
            Workplace workplace = (Workplace) query.getSingleResult();
            return workplace;
        } catch (NoResultException e){
            logger.info("Can not find by name: " + e);
            return null;
        }
    }
}