package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaUserDAOImpl;
import com.cbsgenesis.trmsystem.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Tests for class {@Link JpaUserDAOImpl}
 *
 * @autor Saltykov Dmitriy
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaUserDAOImplTest {

    @Mock
    private JpaUserDAOImpl jpaUserDAO;

    @Mock
    private User user;

    private Collection<User> result;
    private UUID id;

    @Before
    public void setUp(){
            when(jpaUserDAO.getById(user.getId())).thenReturn(user);
            when(user.getId()).thenReturn(id);
            when(jpaUserDAO.findByName("Olia")).thenReturn(user);
            when(user.getUsername()).thenReturn("Olia");
            when(jpaUserDAO.findByName("Dima")).thenReturn(user);
            when(user.getFirstName()).thenReturn("Dima");
            when(jpaUserDAO.getAll()).thenReturn(result);
    }

    @Test
    public void getByIdTest(){
        jpaUserDAO.getById(id);

        verify(jpaUserDAO, times(1)).getById(id);
        assertNotNull(user);
    }

    @Test
    public void saveTest(){
        jpaUserDAO.save(user);

        verify(jpaUserDAO, times(1)).save(user);
        assertNotNull(user);
    }

    @Test
    public void deleteTest(){
        jpaUserDAO.delete(user);

        verify(jpaUserDAO, times(1)).delete(user);
        assertNotNull(user);
    }

    @Test
    public void getAllTest(){
        jpaUserDAO.getAll();

        verify(jpaUserDAO, times(1)).getAll();
        assertEquals(jpaUserDAO.getAll(),result);
    }

    @Test
    public void findByNameTest(){
        jpaUserDAO.findByName(user.getFirstName());

        verify(jpaUserDAO, times(1)).findByName(user.getFirstName());
        assertNotNull(user);
    }
}
