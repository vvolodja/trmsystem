package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaWorkplaceDAOImpl;
import com.cbsgenesis.trmsystem.model.Workplace;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stubVoid;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

/**
 * Implementation of {@link JpaWorkplaceDAOImplTest}
 * 
 * @author Iryna Seliutina
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaWorkplaceDAOImplTest {

    private JpaWorkplaceDAOImpl jpaWorkplaceDAO;
    private Workplace entity;
    UUID uuid;
    private List<Workplace> result;


    @Before
    public void setUp() {
        entity = mock(Workplace.class);
        jpaWorkplaceDAO = mock(JpaWorkplaceDAOImpl.class);
        uuid = entity.getId();
    }

    @Test
    public void saveTest() throws Exception{
        stubVoid(jpaWorkplaceDAO).toReturn().on().save(entity);
        jpaWorkplaceDAO.save(entity);
    }

    @Test
    public void deleteTest()  throws Exception {
        stubVoid(jpaWorkplaceDAO).toReturn().on().delete(entity);
        jpaWorkplaceDAO.delete(entity);
    }

    @Test
    public void getByIdTest() throws Exception {
        when(jpaWorkplaceDAO.getById(uuid)).thenReturn(entity);
        assertEquals(jpaWorkplaceDAO.getById(uuid), entity);
    }

    @Test
    public void getAllTest() throws Exception {
        when(jpaWorkplaceDAO.getAll()).thenReturn(result);
        assertEquals(jpaWorkplaceDAO.getAll(), result);
    }
}