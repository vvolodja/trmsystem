package com.cbsgenesis.trmsystem.service.impl;

import com.cbsgenesis.trmsystem.model.Team;
import com.cbsgenesis.trmsystem.service.TeamService;
import com.cbsgenesis.trmsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

/**
 * Implementation of {@link TeamService} interface
 *
 * @author Anton Lifyrenko
 */
@Service
public class TeamServiceImpl implements TeamService{
    @Override
    public void save(Team team) {

    }

    @Override
    public Team getById(UUID id) {
        return null;
    }

    @Override
    public Team findByUserName(String teamName) {
        return null;
    }

    @Override
    public Collection<Team> getAll() {
        return null;
    }

    @Override
    public void delete(Team team) {

    }
}
