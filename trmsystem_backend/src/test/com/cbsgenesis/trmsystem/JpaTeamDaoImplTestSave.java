package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaTeamDAOImpl;
import com.cbsgenesis.trmsystem.model.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stubVoid;

/**
 * Created by ANTON on 06.03.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaTeamDaoImplTestSave {

    private JpaTeamDAOImpl jpaTeamDAOImpl;
    private Team team;

    @Before
    public void setUp(){
        team = mock(Team.class);
        jpaTeamDAOImpl = mock(JpaTeamDAOImpl.class);
    }

    @Test
    public void saveTest() throws Exception{
        stubVoid(jpaTeamDAOImpl).toReturn().on().save(team);
        jpaTeamDAOImpl.save(team);
    }
}
