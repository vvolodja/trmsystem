package com.cbsgenesis.trmsystem.service.impl;

import com.cbsgenesis.trmsystem.dao.RoleDAO;
import com.cbsgenesis.trmsystem.model.Role;
import com.cbsgenesis.trmsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

/**
 * Implementation of {@link RoleService} interface.
 *
 * @author Eugene Suleimanov
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public Role getById(UUID id) {
        return roleDAO.getById(id);
    }

    @Override
    @Transactional
    public Role findByName(String name) {
        return roleDAO.findByName(name);
    }

    @Override
    @Transactional
    public Collection<Role> getAll() {
        return roleDAO.getAll();
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleDAO.save(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        roleDAO.delete(role);
    }
}