package com.cbsgenesis.trmsystem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stubVoid;

import com.cbsgenesis.trmsystem.dao.jpa.JpaStatusDAOImpl;
import com.cbsgenesis.trmsystem.model.Status;

import java.util.List;
import java.util.UUID;

/**
 * Created by Alena on 23.03.2017.
 * Test for all method class JpaDAOStatusImpl
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaStatusDAOImplTest {
    private JpaStatusDAOImpl jpaStatusDAO;
    private Status status;
    private List<Status> statusList;
    UUID id;

    @Before
    public void setUp() {
        status = mock(Status.class);
        jpaStatusDAO = mock(JpaStatusDAOImpl.class);
    }

    @Test
    public void saveStatus() throws Exception {
        stabVoid(jpaStatusDAO).toReturn().on().save(status);
        jpaStatusDAO.save(status);
    }

    @Test
    public void getByIdStatus() throws Exception {
        when(jpaStatusDAO.getById(id)).thenReturn(status);
        assertEquals(jpaStatusDAO.getById(id), status)
    }

    @Test
    public void getAllStatus() throws Exception {
        when(jpaStatusDAO.getAll()).thenReturn(statusList);
        assertEquals(jpaStatusDAO.getAll(), statusList)
    }

    @Test
    public void saveStatus() throws Exception {
        stabVoid(jpaStatusDAO).toReturn().on().delete(status);
        jpaStatusDAO.delete(status);
    }


}
