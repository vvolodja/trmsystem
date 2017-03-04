package com.cbsgenesis.trmsystem.dao.jpa;

import com.cbsgenesis.trmsystem.dao.TeamDAO;
import com.cbsgenesis.trmsystem.dao.UserDAO;
import com.cbsgenesis.trmsystem.model.Team;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.UUID;

/**
 * Implementation of {@link TeamDAO} interface.
 *
 * @author Anton Lifyrenko
 */

@Repository
public class JpaTeamDAOImpl implements TeamDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final static Logger logger = Logger.getLogger(JpaTeamDAOImpl.class);

    @Override
    public void save(Team team) {
        if (team.getId() == null) {
            this.entityManager.persist(team);
            logger.info("Team successfully saved. Team details: " + team);
        } else {
            this.entityManager.merge(team);
            logger.info("Team successfully updated. Team details: " + team);
        }
    }

    @Override
    public Team getById(UUID id) {
        Query query = this.entityManager.createQuery("SELECT DISTINCT team FROM Team team WHERE team.id = :id");
        query.setParameter("id", id);

        Team team = (Team) query.getSingleResult();
        logger.info("Team successfully loaded. Team details: " + team);

        return team;
    }

    @Override
    public Collection<Team> getAll() {
        Collection<Team> result;
        Query query = this.entityManager.createQuery("SELECT team FROM Team team");
        result = query.getResultList();

        for (Team team : result) {
            logger.info("Team list: " + team);
        }

        return result;
    }

    @Override
    public void delete(Team team) {
        this.entityManager.remove(team);
        logger.info("Team successfully removed. Team details: " + team);
    }
}
