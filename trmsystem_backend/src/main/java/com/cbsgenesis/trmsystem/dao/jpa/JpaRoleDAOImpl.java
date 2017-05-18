package com.cbsgenesis.trmsystem.dao.jpa;

import com.cbsgenesis.trmsystem.dao.RoleDAO;
import com.cbsgenesis.trmsystem.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 * JPA implementation of {@link RoleDAO} interface.
 *
 * @author Eugene Suleimanov
 */

@Repository
public class JpaRoleDAOImpl implements RoleDAO {

  @PersistenceContext
  private EntityManager entityManager;

  private final static Logger logger = Logger.getLogger(JpaRoleDAOImpl.class);

  @SuppressWarnings("unchecked")
  @Override
  public Role getById(UUID id) {
    Query query = this.entityManager.createQuery("SELECT DISTINCT  role FROM  Role role LEFT JOIN FETCH  role.users WHERE role.id =:id");
    query.setParameter("id", id);

    Role role = (Role) query.getSingleResult();
    logger.info("Role successfully loaded. Role details: " + role);

    return role;
  }


  @Override
  public Role findByName(String name) {
    try {
      Query query = this.entityManager.createQuery("FROM Role role WHERE role.name=:name", Role.class);
      query.setParameter("name", name);
      Role role = (Role) query.getSingleResult();
      return role;
    } catch (NoResultException e) {
      logger.info("NoResultException: " + e);
      return null;
    }
  }

  @Override
  public Collection<Role> getAll() {
    Collection<Role> result;
    Query query = this.entityManager.createQuery("SELECT role FROM Role role");
    result = query.getResultList();

    for (Role role : result) {
      logger.info("Role list: " + role);
    }

    return result;
  }

  @Override
  public void save(Role role) {
    if (role.getId() == null) {
      this.entityManager.persist(role);
      logger.info("Role successfully saved. Role details: " + role);
    } else {
      this.entityManager.merge(role);
      logger.info("Role successfully updated. Role details: " + role);
    }
  }

  @Override
  public void delete(Role role) {
    Role roleForDeleting = getById(role.getId());
    entityManager.remove(roleForDeleting);
    logger.info("Role successfully removed. Role details: " + role);
  }
}
