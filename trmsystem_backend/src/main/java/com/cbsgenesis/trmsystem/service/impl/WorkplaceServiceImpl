package com.cbsgenesis.trmsystem.service.impl;

import com.cbsgenesis.trmsystem.dao.WorkplaceDAO;
import com.cbsgenesis.trmsystem.model.Workplace;
import com.cbsgenesis.trmsystem.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

/**
 * Implementation of {@link WorkplaceService} interface.
 *
 * @author Iryna Seliutina.
 */
@Service
public class WorkplaceServiceImpl implements WorkplaceService {

    @Autowired
    private WorkplaceDAO workplaceDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    @Transactional
    public void save(Workplace entity) {
       workplaceDAO.save(entity);

    }

    @Override
    @Transactional
    public Workplace getById(UUID uuid) {
        return workplaceDAO.getById(uuid);
    }

    @Override
    @Transactional
    public Workplace findByName(String name) {
        return workplaceDAO.findByName(name);
    }

    @Override
    @Transactional
    public Collection<Workplace> getAll() {
        return workplaceDAO.getAll();
    }

    @Override
    @Transactional
    public void delete(Workplace entity) {
        workplaceDAO.delete(entity);

    }
}