package com.cbsgenesis.trmsystem.dao.jpa;

import com.cbsgenesis.trmsystem.dao.SpecialtyDAO;
import com.cbsgenesis.trmsystem.model.Specialty;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.UUID;

/**
 * Implementation of {@link SpecialtyDAO} interface.
 *
 * @author Oleksii Samantsov
 */

@SuppressWarnings("JpaQlInspection")
@Repository
public class JpaSpecialtyDAOImpl implements SpecialtyDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final static Logger logger = Logger.getLogger(JpaSpecialtyDAOImpl.class);


    @Override
    public void save(Specialty specialty) {
        if(specialty.getId() == null){
            this.entityManager.persist(specialty);
            logger.info("Specialty successfully saved. Specialty details: " + specialty);
        } else {
            this.entityManager.merge(specialty);
            logger.info("Specialty successfully updated. Specialty details: " + specialty);
        }
    }

    @Override
    public Specialty getById(UUID id) {
        Query query = this.entityManager.createQuery("SELECT DISTINCT specialty FROM SPECIALTIES specialty WHERE specialty.id = :id");
        query.setParameter("id", id);

        Specialty specialty = (Specialty) query.getSingleResult();
        logger.info("Specialty successfully loaded. Specialty details: " + specialty);
        return specialty;
    }

    @Override
    public Collection<Specialty> getAll() {
        Collection<Specialty> result;
        Query query = this.entityManager.createQuery("SELECT specialty FROM SPECIALTIES specialty");
        result = query.getResultList();

        for(Specialty specialty : result){
            logger.info("Specialty list: " + specialty);
        }
        return result;
    }

    @Override
    public void delete(Specialty specialty) {
        entityManager.remove(entityManager.getReference(Specialty.class, specialty.getId()));
        logger.info("Specialty successfully removed. Specialty details: " + specialty);
    }

    public Specialty findByName(String specialtyName){
        Specialty specialty = null;
        try{
            Query query = this.entityManager.createQuery("SELECT DISTINCT specialty FROM SPECIALTIES specialty WHERE specialty.name= :name", Specialty.class);
            query.setParameter("name", specialtyName);
            specialty = (Specialty) query.getSingleResult();
        } catch (NoResultException e){
            logger.error("Can't get specialty by specialtyName = '" + specialtyName + "'", e);
        }
        return specialty;
    }
}
