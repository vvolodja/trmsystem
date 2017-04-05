package com.cbsgenesis.trmsystem.service.impl;

import com.cbsgenesis.trmsystem.dao.StatusDAO;
import com.cbsgenesis.trmsystem.model.Status;
import com.cbsgenesis.trmsystem.service.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by Alena on 18.03.2017.
 * Implementation {@link StatusService} interface
 */
@Service
public class StatusServiceImpl implements StatusService {
    private static final Logger logger = LoggerFactory.getLogger(StatusServiceImpl.class);

    @Autowired
    private StatusDAO statusDAO;


    @Override
    @Transactional
    public Status getById(UUID id) {
        return statusDAO.getById(id);
    }

    @Override
    @Transactional
    public Collection<Status> getAll() {
        return statusDAO.getAll();
    }

    @Override
    @Transactional
    public void save(Status status) {
        statusDAO.save(status);
    }

    @Override
    @Transactional
    public void delete(Status status) {
        statusDAO.delete(status);
    }
}

