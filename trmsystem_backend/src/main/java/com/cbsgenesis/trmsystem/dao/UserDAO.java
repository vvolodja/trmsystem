package com.cbsgenesis.trmsystem.dao;

import com.cbsgenesis.trmsystem.model.User;

import java.util.UUID;

/**
 * Extension of {@link GenericDAO} interface for {@link User} class.
 *
 * @author Eugene Suleimanov
 */
public interface UserDAO extends GenericDAO<User, UUID> {

    User findByName(String name);
}
