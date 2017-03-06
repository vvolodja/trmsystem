package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaTeamDAOImpl;
import com.cbsgenesis.trmsystem.model.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stubVoid;

/**
 * Created by ANTON on 06.03.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaTeamDAOImplTestDelete {
    private JpaTeamDAOImpl jpaTeamDAOImpl;
    private Team team;
    UUID id;

    @Before
    public void setUp(){
        team = mock(Team.class);
        jpaTeamDAOImpl = mock(JpaTeamDAOImpl.class);
    }

    @Test
    public void getByIdTest() throws Exception {
        stubVoid(jpaTeamDAOImpl).toReturn().on().delete(team);
        jpaTeamDAOImpl.delete(team);
    }
}
