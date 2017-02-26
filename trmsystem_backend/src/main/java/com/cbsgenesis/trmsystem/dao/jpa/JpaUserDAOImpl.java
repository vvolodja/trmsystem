package com.cbsgenesis.trmsystem.dao.jpa;

import com.cbsgenesis.trmsystem.dao.UserDAO;
import com.cbsgenesis.trmsystem.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;

/**
 * Implementation of {@link UserDAO} interface.
 *
 * @author Eugene Suleimanov
 */

@Repository
public class JpaUserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    private final static Logger logger = Logger.getLogger(JpaRoleDAOImpl.class);

    @Override
    public User getById(UUID id) {
        Query query = this.entityManager.createQuery(
                "SELECT DISTINCT user FROM  User user LEFT JOIN FETCH user.roles " +
                        "WHERE user.id =:id");
        query.setParameter("id", id);
        User user = (User) query.getSingleResult();

        logger.info("User successfully loaded. User details: " + user);

        return user;
    }


    @Override
    public User findByName(String username) {

        try {
            Query query = this.entityManager.createQuery(
                    "SELECT DISTINCT user FROM  User user LEFT JOIN FETCH user.roles " +
                            "WHERE user.username=:name", User.class);
            query.setParameter("name", username);
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Collection<User> getAll() {
        Collection<User> result;

        Query query = this.entityManager.
                createQuery("SELECT DISTINCT user FROM User user " +
                        "LEFT JOIN FETCH user.roles");
        result = query.getResultList();

        for (User user : result) {
            logger.info("User list: " + user);
        }

        return result;
    }

    @Override
    public void save(User user) {
        user.setRegistrationDate(new Date());
        if (user.getId() == null) {
            this.entityManager.persist(user);
            logger.info("User successfully saved. User details: " + user);
        } else {
            this.entityManager.merge(user);
            logger.info("User successfully updated. User details: " + user);
        }
    }

    @Override
    public void delete(User user) {
        this.entityManager.remove(user);
    }
}
