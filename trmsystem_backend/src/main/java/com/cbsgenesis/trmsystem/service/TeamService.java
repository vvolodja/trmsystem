package com.cbsgenesis.trmsystem.service;

import com.cbsgenesis.trmsystem.model.Team;
import com.cbsgenesis.trmsystem.model.User;

import java.util.Collection;
import java.util.UUID;

/**
 * Service class for class {@link Team}
 *
 * @author Anton Lifyrenko
 */
public interface TeamService {

    void save(Team team);

    Team getById(UUID id);

    Team findByTeamName(String teamName);

    Collection<Team> getAll();

    void delete(Team team);
}
