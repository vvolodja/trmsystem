import com.cbsgenesis.trmsystem.dao.jpa.JpaEventDAOImpl;
import com.cbsgenesis.trmsystem.model.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stubVoid;

/**
 * Created by Orange on 10.03.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class JpaEventDaoImplTestSave {
    private JpaEventDAOImpl jpaEventDaoImpl;
    private Event event;

    @Before
    public void setUp(){
        event = mock(Event.class);
        jpaEventDaoImpl = mock(JpaEventDAOImpl.class);
    }

    @Test
    public void saveTest() throws Exception{
        stubVoid(jpaEventDaoImpl).toReturn().on().save(event);
        jpaEventDaoImpl.save(event);
    }
}
