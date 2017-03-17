package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaEventDAOImpl;
import com.cbsgenesis.trmsystem.model.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test for method GetAll class JpaEventDaoImpl
 */

/**
 * Created by Orange on 09.03.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaEventDaoImplTestGetAll {
    private JpaEventDAOImpl jpaEventDaoImpl;
    private List<Event> events;

    @Before
    public void setUp() throws Exception{
        events = mock(List.class);
        jpaEventDaoImpl = mock(JpaEventDAOImpl.class);
    }

    @Test
    public void getAllTest() throws Exception{
        when(jpaEventDaoImpl.getAll()).thenReturn(events);
        assertEquals(jpaEventDaoImpl.getAll(), events);
    }
}
