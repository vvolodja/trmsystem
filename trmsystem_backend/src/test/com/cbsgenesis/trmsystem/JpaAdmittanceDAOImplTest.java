package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaAdmittanceDAOImpl;
import com.cbsgenesis.trmsystem.model.Admittance;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Tests for class {@link JpaAdmittanceDAOImpl}.
 *
 * @author Kyryl Potapenko
 * @since 2017-03-19
 */
@RunWith(MockitoJUnitRunner.class)
public class JpaAdmittanceDAOImplTest {

    @Mock
    private JpaAdmittanceDAOImpl admittanceDAO;
    @Mock
    private Admittance admittance;

    private Collection<Admittance> result;
    private final UUID id = UUID.fromString("f818e904-b7a1-40c1-83fa-598102162159");

    @Before
    public void setUp() throws NoSuchFieldException {
        MockitoAnnotations.initMocks(this);
        when(admittanceDAO.getById(id)).thenReturn(admittance);
        when(admittance.getId()).thenReturn(id);
        when(admittanceDAO.findByName("INSTRUCTOR")).thenReturn(admittance);
        when(admittance.getName()).thenReturn("INSTRUCTOR");
        when(admittanceDAO.getAll()).thenReturn(result);
    }

    @Test
    public void getByIdTest() throws NoSuchFieldException {
        admittanceDAO.getById(id);

        verify(admittanceDAO, times(1)).getById(id);
        assertEquals(admittanceDAO.getById(id), admittance);
    }

    @Test
    public void saveTest() {
        admittanceDAO.save(admittance);

        verify(admittanceDAO, times(1)).save(admittance);
        assertNotNull(admittance);
    }

    @Test
    public void getAllTest() {
        admittanceDAO.getAll();

        verify(admittanceDAO, times(1)).getAll();
        assertEquals(admittanceDAO.getAll(), result);
    }

    @Test
    public void deleteTest() {
        admittanceDAO.delete(admittance);

        verify(admittanceDAO, times(1)).delete(admittance);
        assertNotNull(admittance);
    }

    @Test
    public void findByNameTest() {
        Admittance admittance = admittanceDAO.findByName("INSTRUCTOR");

        verify(admittanceDAO, times(1)).findByName(anyString());
        assertEquals("INSTRUCTOR", admittance.getName());
    }
}
