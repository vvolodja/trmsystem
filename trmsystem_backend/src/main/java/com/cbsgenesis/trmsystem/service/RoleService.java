package com.cbsgenesis.trmsystem.service;


import com.cbsgenesis.trmsystem.model.Role;

import java.util.Collection;
import java.util.UUID;

/**
 * Service interface for class {@link Role}.
 *
 * @author Eugene Suleimanov
 */
public interface RoleService {

    Role getById(UUID id);

    Role findByName(String name);

    Collection<Role> getAll();

    void save(Role role);

    void delete(Role role);

}
