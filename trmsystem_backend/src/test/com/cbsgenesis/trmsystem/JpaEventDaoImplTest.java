package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaEventDAOImpl;
import com.cbsgenesis.trmsystem.model.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stubVoid;
import static org.mockito.Mockito.when;

/**
 * Test for method getById class JpaEventDaoImpl
 */

/**
 * Created by Orange on 10.03.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaEventDaoImplTest {
    private JpaEventDAOImpl jpaEventDAOImpl;
    private Event event;
    private List<Event> events;
    UUID id;

    @Before
    public  void setUp(){
        event = mock(Event.class);
        jpaEventDAOImpl = mock(JpaEventDAOImpl.class);
        id = event.getId();
    }

    @Test
    public void getByIdTest() throws Exception{
        when(jpaEventDAOImpl.getById(id)).thenReturn(event);
        assertEquals(jpaEventDAOImpl.getById(id), event);
    }

    @Test
    public void saveTest() throws Exception{
        stubVoid(jpaEventDAOImpl).toReturn().on().save(event);
        jpaEventDAOImpl.save(event);
    }

    @Test
    public void getAllTest() throws Exception {
        when(jpaEventDAOImpl.getAll()).thenReturn(events);
        assertEquals(jpaEventDAOImpl.getAll(), events);
    }

    @Test
    public void deleteEventTest() throws Exception {
        stubVoid(jpaEventDAOImpl).toReturn().on().delete(event);
        jpaEventDAOImpl.delete(event);
    }
}
