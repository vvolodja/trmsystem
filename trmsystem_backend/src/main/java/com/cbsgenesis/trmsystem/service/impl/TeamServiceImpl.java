package com.cbsgenesis.trmsystem.service.impl;

import com.cbsgenesis.trmsystem.dao.TeamDAO;
import com.cbsgenesis.trmsystem.dao.jpa.JpaTeamDAOImpl;
import com.cbsgenesis.trmsystem.model.Team;
import com.cbsgenesis.trmsystem.service.TeamService;
import com.cbsgenesis.trmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

/**
 * Implementation of {@link TeamService} interface
 *
 * @author Anton Lifyrenko
 */
@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamDAO teamDAO;

    @Override
    @Transactional
    public void save(Team team) {
        teamDAO.save(team);
    }

    @Override
    public Team getById(UUID id) {
        return teamDAO.getById(id);
    }

    @Override
    @Transactional
    public Team findByTeamName(String teamName) {
        return teamDAO.findByName(teamName);
    }

    @Override
    @Transactional
    public Collection<Team> getAll() {
        return teamDAO.getAll();
    }

    @Override
    @Transactional
    public void delete(Team team) {
        teamDAO.delete(team);
    }
}
