package com.cbsgenesis.trmsystem.dao.jpa;

import com.cbsgenesis.trmsystem.dao.AdmittanceDAO;
import com.cbsgenesis.trmsystem.model.Admittance;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.UUID;

/**
 * JPA implementation of {@link AdmittanceDAO} interface.
 *
 * @author Kyryl Potapenko
 */
@Repository
public class JpaAdmittanceDAOImpl implements AdmittanceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final static Logger logger = Logger.getLogger(JpaAdmittanceDAOImpl.class);

    @Override
    public void save(Admittance admittance) {
        if (admittance.getId() == null) {
            this.entityManager.persist(admittance);
            logger.info("Admittance successfully saved. Admittance details: " + admittance);
        } else {
            this.entityManager.merge(admittance);
            logger.info("Admittance successfully updated. Admittance details: " + admittance);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Admittance getById(UUID id) {
        Query query = this.entityManager.createQuery(
                "SELECT DISTINCT admittance FROM  Admittance admittance LEFT JOIN FETCH admittance.specialists " +
                        "WHERE admittance.id =:id");
        query.setParameter("id", id);
        Admittance admittance = (Admittance) query.getSingleResult();

        logger.info("Admittance successfully loaded. Admittance details: " + admittance);

        return admittance;
    }

    @Override
    public Collection<Admittance> getAll() {
        Collection<Admittance> result;
        Query query = this.entityManager.createQuery("SELECT admittance FROM Admittance admittance");
        result = query.getResultList();

        for (Admittance admittance : result) {
            logger.info("Admittance list: " + admittance);
        }
        return result;
    }

    @Override
    public void delete(Admittance admittance) {
        this.entityManager.remove(admittance);
        logger.info("Admittance successfully removed. Admittance details: " + admittance);
    }

    @Override
    public Admittance findByName(String name) {
        try {
            Query query = this.entityManager.createQuery("FROM Admittance admittance WHERE admittance.name=:name", Admittance.class);
            query.setParameter("name", name);
            Admittance admittance = (Admittance) query.getSingleResult();
            return admittance;
        } catch (NoResultException e) {
            logger.info("Can't find by name: " + e);
            return null;
        }
    }
}
