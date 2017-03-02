package com.cbsgenesis.trmsystem.dao.jpa;

import com.cbsgenesis.trmsystem.dao.SpecialistDAO;
import com.cbsgenesis.trmsystem.model.Specialist;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by NoteBook on 01.03.2017.
 */

@Repository
public class JpaSpecialistDAOImpl implements SpecialistDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final static Logger logger = Logger.getLogger(JpaSpecialistDAOImpl.class);

    @Override
    public void save(Specialist specialist) {
        if (specialist.getId() == null) {
            this.entityManager.persist(specialist);
            logger.info("Specialist successfully saved. Specialist details: " + specialist);
        } else {
            this.entityManager.merge(specialist);
            logger.info("Specialist successfully updated. Specialist details: " + specialist);
        }
    }

    @Override
    public Specialist getById(UUID id) {
        Query query = this.entityManager.createQuery(
                "SELECT DISTINCT specialist FROM  Specialist specialist LEFT JOIN FETCH specialist.user " +
                        "WHERE specialist.id =:id");
        query.setParameter("id", id);
        Specialist specialist = (Specialist) query.getSingleResult();

        logger.info("Specialist successfully loaded. Specialist details: " + specialist);

        return specialist;
    }

    @Override
    public Collection<Specialist> getAll() {
        Collection<Specialist> result;
        Query query = this.entityManager.createQuery("SELECT specialist FROM Specialist specialist");
        result = query.getResultList();

        for (Specialist specialist : result) {
            logger.info("Role list: " + specialist);
        }

        return result;
    }

    @Override
    public void delete(Specialist specialist) {
        this.entityManager.remove(specialist);
        logger.info("Specialist successfully remove. Specialist details: "+ specialist);
    }

    @Override
    public Specialist findByName(String name) {
        return null;
    }
}
