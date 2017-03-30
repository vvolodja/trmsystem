package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaSpecialtyDAOImpl;
import com.cbsgenesis.trmsystem.model.Specialty;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Test for class {@link JpaSpecialtyDAOImpl}
 *
 * @author Oleksii Samantsov
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaSpecialtyDAOImplTest {


    private JpaSpecialtyDAOImpl specialtyDAO;
    private Specialty specialty;
    private Collection<Specialty> result;
    private UUID id;

    @Before
    public void setUp(){
        result = mock(List.class);
        specialtyDAO = mock(JpaSpecialtyDAOImpl.class);
        specialty = mock(Specialty.class);
        id = specialty.getId();
    }

    @Test(expected = NullPointerException.class)
    public void nullCreateThrowsException(){
        new JpaSpecialtyDAOImpl().save(specialty);
    }



    @Test
    public void testSave() throws Exception {
        specialtyDAO.save(specialty);
        verify(specialtyDAO, times(1)).save(specialty);
        assertNotNull(specialty);
    }

    @Test
    public void testGetById() throws Exception {
        when(specialtyDAO.getById(id)).thenReturn(specialty);
        assertEquals(specialtyDAO.getById(id), specialty);
    }

    @Test
    public void testGetAll() throws Exception {
        when(specialtyDAO.getAll()).thenReturn(result);
        assertEquals(specialtyDAO.getAll(), result);
    }

    @Test
    public void testDelete() throws Exception {
        specialtyDAO.delete(specialty);
        assertNull(specialtyDAO.getById(specialty.getId()));
    }



    @Test
    public void testFindByName() throws Exception {
        when(specialtyDAO.findByName(specialty.getName())).thenReturn(specialty);
        assertEquals(specialtyDAO.findByName(specialty.getName()), specialty);
    }

}