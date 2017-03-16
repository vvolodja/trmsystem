package com.cbsgenesis.trmsystem.dao.jpa;

import com.cbsgenesis.trmsystem.dao.EventDAO;
import com.cbsgenesis.trmsystem.model.Event;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.UUID;

import org.apache.log4j.Logger;

/**
 * Created by Orange on 04.03.2017.
 */

@Repository
public class JpaEventDAOImpl implements EventDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final static Logger logger = Logger.getLogger(JpaEventDAOImpl.class);

    @Override
    public void save(Event event) {
        if (event.getId() == null) {
            this.entityManager.persist(event);
            logger.info("Event saccesfully saved. Event details:" + event);
        } else {
            this.entityManager.merge(event);
            logger.info("Event saccesfully updated. Event details:" + event);
        }

    }

    @Override
    public Event getById(UUID id) {
        Query query = this.entityManager.createQuery
                ("SELECT DISTINCT event FROM EVENT even WHERE event.id = :id");
        query.setParameter("id", id);

        Event event = (Event) query.getSingleResult();
        logger.info("Event succesfully loaded. Event details:" + event);
        return event;
    }

    @Override
    public Collection<Event> getAll() {
        Collection<Event> result;
        Query query = this.entityManager.createQuery("SELECT event FROM Event event");
        result = query.getResultList();

        for (Event event : result) {
            logger.info("Event list:" + event);
        }
        return result;
    }

    public void delete(Event event) {
        this.entityManager.remove(event);
        logger.info("Event succesfully removed. Event details:" + event);
    }

    @Override
    public Event findByName(String name) {
        try {
            Query query = this.entityManager.createQuery("FROM Event event WHERE event.name=:name", Event.class);
            query.setParameter("name", name);
            Event event = (Event) query.getSingleResult();
            return event;
        } catch (NoResultException e) {
            logger.info("Cant find by name:" + e);
            return null;
        }
    }
}
