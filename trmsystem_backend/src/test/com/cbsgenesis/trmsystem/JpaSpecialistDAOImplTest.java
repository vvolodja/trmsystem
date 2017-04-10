package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaSpecialistDAOImpl;
import com.cbsgenesis.trmsystem.model.Specialist;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for class {@link JpaSpecialistDAOImpl}.
 *
 * @autor Saltykov Dmitriy
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaSpecialistDAOImplTest {

    @Mock
    private JpaSpecialistDAOImpl jpaSpecialistDAO;

    @Mock
    private Specialist specialist;

    private Collection<Specialist> result;
    private UUID id;

    @Before
    public void setUp() {
        when(jpaSpecialistDAO.getById(specialist.getId())).thenReturn(specialist);
        when(specialist.getId()).thenReturn(id);
        when(jpaSpecialistDAO.findByName("Ivanov")).thenReturn(specialist);
        when(specialist.getFirstName()).thenReturn("Ivanov");
        when(jpaSpecialistDAO.getAll()).thenReturn(result);
    }

    @Test
    public void getByIdTest() {
        jpaSpecialistDAO.getById(id);

        verify(jpaSpecialistDAO, times(1)).getById(id);
        assertEquals(jpaSpecialistDAO.getById(id), specialist);
    }

    @Test
    public void saveTest() {
        jpaSpecialistDAO.save(specialist);

        verify(jpaSpecialistDAO, times(1)).save(specialist);
        assertNotNull(specialist);
    }

    @Test
    public void deleteTest(){
        jpaSpecialistDAO.delete(specialist);

        verify(jpaSpecialistDAO, times(1)).delete(specialist);
        assertNotNull(specialist);
    }

    @Test
    public void getAllTest(){
        jpaSpecialistDAO.getAll();

        verify(jpaSpecialistDAO, times(1)).getAll();
        assertEquals(jpaSpecialistDAO.getAll(), result);
    }

}
