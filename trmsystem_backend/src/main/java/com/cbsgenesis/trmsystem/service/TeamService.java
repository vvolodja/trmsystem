package com.cbsgenesis.trmsystem.service;

import com.cbsgenesis.trmsystem.model.Team;
import com.cbsgenesis.trmsystem.model.User;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by ANTON on 27.02.2017.
 */
public interface TeamService {

    void save(Team team);

    Team getById(UUID id);

    Team findByUserName(String teamName);

    Collection<Team> getAll();

    void delete(Team team);
}
