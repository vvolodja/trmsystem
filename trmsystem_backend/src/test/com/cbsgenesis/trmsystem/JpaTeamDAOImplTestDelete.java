package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaTeamDAOImpl;
import com.cbsgenesis.trmsystem.model.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ANTON on 06.03.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaTeamDAOImplTestDelete {
    private JpaTeamDAOImpl jpaTeamDAOImpl;
    List<Team> teams;

    @Before
    public void setUp(){
        teams = mock(List.class);
        jpaTeamDAOImpl = mock(JpaTeamDAOImpl.class);
    }

    @Test
    public void getByIdTest() throws Exception {
        when(jpaTeamDAOImpl.getAll()).thenReturn(teams);
        assertEquals(jpaTeamDAOImpl.getAll(), teams);
    }

}
