package com.cbsgenesis.trmsystem.service.impl;

import com.cbsgenesis.trmsystem.dao.AdmittanceDAO;
import com.cbsgenesis.trmsystem.model.Admittance;
import com.cbsgenesis.trmsystem.service.AdmittanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;
@Service
public class AdmittanceServiceImpl implements AdmittanceService {
    @Autowired
    private AdmittanceDAO admittanceDAO;

    @Override
    @Transactional
    public Admittance getById(UUID id) {
        return admittanceDAO.getById(id);
    }

    @Override
    @Transactional
    public Admittance findByName(String name) {
        return admittanceDAO.findByName(name);
    }

    @Override
    @Transactional
    public Collection<Admittance> getAll() {
        return admittanceDAO.getAll();
    }

    @Override
    @Transactional
    public void save(Admittance role) {
        admittanceDAO.save(role);
    }

    @Override
    @Transactional
    public void delete(Admittance role) {
        admittanceDAO.delete(role);
    }
}
