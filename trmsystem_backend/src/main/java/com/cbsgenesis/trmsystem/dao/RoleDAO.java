package com.cbsgenesis.trmsystem.dao;

import com.cbsgenesis.trmsystem.model.Role;

import java.util.UUID;

/**
 * Extension of {@link GenericDAO} interface for {@link Role} class.
 *
 * @author Eugene Suleimanov
 */

public interface RoleDAO extends GenericDAO<Role, UUID> {

    Role findByName(String name);
}
