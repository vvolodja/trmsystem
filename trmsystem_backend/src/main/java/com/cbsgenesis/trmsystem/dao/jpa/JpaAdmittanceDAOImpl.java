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
 * @since 2017-03-03
 */
@Repository
public class JpaAdmittanceDAOImpl implements AdmittanceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final static Logger logger = Logger.getLogger(JpaAdmittanceDAOImpl.class);

    /**
     * Saves an entity of class {@link Admittance} in a relational database
     *
     * @param admittance an Admittance object
     * @see Admittance
     */
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

    /**
     * This method is used to get an entity of class {@link Admittance} from the database
     *
     * @param id Specifies the unique id
     * @return an Admittance object at the specified id
     * @see Admittance
     */
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

    /**
     * This method is used to get all objects of class {@link Admittance} from the database
     *
     * @return collection of Admittance objects
     */
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

    /**
     * Delete an entity of class {@link Admittance} from the database
     *
     * @param admittance an Admittance object
     * @see Admittance
     */
    @Override
    public void delete(Admittance admittance) {
        this.entityManager.remove(admittance);
        logger.info("Admittance successfully removed. Admittance details: " + admittance);
    }

    /**
     * This method is used to get an entity of class {@link Admittance}
     *
     * @param name Specifies the fild "name" of Admittance object
     * @return an Admittance object at the specified name,
     *         null when @exception NoResultException occurred
     * @see Admittance
     */
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
