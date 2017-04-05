package com.cbsgenesis.trmsystem.dao.jpa;

import com.cbsgenesis.trmsystem.dao.StatusDAO;
import com.cbsgenesis.trmsystem.model.Status;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by Alena on 18.03.2017.
 * JPA implementation of {@link StatusDAO) interface
 */
@Repository
public class JpaStatusDAOImpl implements StatusDAO {
    @PersistenceContext
    private EntityManager entityManager;
    private final static Logger logger = Logger.getLogger(JpaStatusDAOImpl.class);

    @Override
    public void save(Status status) {
        if (status.getId() == null) {
            this.entityManager.persist(status);
            logger.info("Status saved");
        } else {
            this.entityManager.merge(status);
            logger.info("Status successfully updated, status is  " + status);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Status getById(UUID id) {
        Query query = this.entityManager.createQuery("SELECT DISTINCT status FROM Status status " +
                "LEFT JOIN FETCH status.user " +
                "WHERE status.id= id");

        query.setParameter("id", id);

        Status status = (Status) query.getSingleResult();
        logger.info("Status successfully loaded. Details: " + status);
        return status;
    }

    @Override
    public Collection<Status> getAll() {
        Collection<Status> statusCollection;
        Query query = this.entityManager.createQuery("SELECT status FROM Status status");
        statusCollection = query.getResultList();

        for (Status status : statusCollection
                ) {
            logger.info("Status list: " + status);
        }
        return statusCollection;
    }

    @Override
    public void delete(Status status) {
        this.entityManager.remove(status);
    }

}
