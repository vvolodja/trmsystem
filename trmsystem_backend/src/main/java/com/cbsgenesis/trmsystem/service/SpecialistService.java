package com.cbsgenesis.trmsystem.service;

import com.cbsgenesis.trmsystem.model.Specialist;

import java.util.Collection;
import java.util.UUID;

/**
 * Service interface for class {@Link Specialist}.
 *
 * @author Dmitriy Saltykov
 */

public interface SpecialistService {

    Collection<Specialist> getAll();

    void save (Specialist specialist);

    void delete (Specialist specialist);

    Specialist getById (UUID id);

    Specialist findByLastName (String lastName);

}
