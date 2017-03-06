package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaTeamDAOImpl;
import com.cbsgenesis.trmsystem.model.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ANTON on 06.03.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaTeamDAOImplTestGetById {

    private JpaTeamDAOImpl jpaTeamDAOImpl;
    private Team team;
    UUID id;

    @Before
    public void setUp(){
        team = mock(Team.class);
        jpaTeamDAOImpl = mock(JpaTeamDAOImpl.class);
        id = team.getId();
    }

    @Test
    public void getByIdTest() throws Exception {
        when(jpaTeamDAOImpl.getById(id)).thenReturn(team);
        assertEquals(jpaTeamDAOImpl.getById(id), team);
    }
}
