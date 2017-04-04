package com.cbsgenesis.trmsystem.service;

import com.cbsgenesis.trmsystem.model.Workplace;

import java.util.Collection;
import java.util.UUID;

/**
 * Service class for {@link Workplace}
 * 
 * @uuthor: Iryna Seliutina.
 */
 
public interface WorkplaceService {

    void save(Workplace entity);

    Workplace getById(UUID uuid);

    Workplace findByName(String name);

    Collection<Workplace> getAll();

    void delete(Workplace entity);
}
