package com.cbsgenesis.trmsystem.service;

import com.cbsgenesis.trmsystem.model.Admittance;

import java.util.Collection;
import java.util.UUID;

/**
 * Service interface for class {@link Admittance}.
 *
 * @author Kyryl Potapenko
 */
public interface AdmittanceService {
    Admittance getById(UUID id);

    Admittance findByName(String name);

    Collection<Admittance> getAll();

    void save(Admittance role);

    void delete(Admittance role);
}
