package com.cbsgenesis.trmsystem.service;

import com.cbsgenesis.trmsystem.model.Status;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by Alena on 18.03.2017.
 * Service interface for class {@link Status})
 */
public interface StatusService {
    Status getById(UUID id);

    Collection<Status> getAll();

    void save(Status status);

    void delete(Status status);
}

