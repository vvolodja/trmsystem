package com.cbsgenesis.trmsystem;

import com.cbsgenesis.trmsystem.dao.jpa.JpaRoleDAOImpl;
import com.cbsgenesis.trmsystem.model.Role;
import com.cbsgenesis.trmsystem.model.Team;
import com.cbsgenesis.trmsystem.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Vasiliy Kylik on 30.03.2017.
 */


@RunWith(MockitoJUnitRunner.class)
public class JpaRoleDAOImplTest {
  /*
  JpaRoleDAOImpl contains next methods:
  public Role getById(UUID id)
  public Role findByName(String name)
  public Collection<Role> getAll()
  public void save(Role role)
  public void delete(Role role)
  */
  private JpaRoleDAOImpl jpaRoleDAOImpl;
  private List<Role> roles;
  private Role role;
  private List<User> users;
  private User user;
  private UUID id;

  @Before
  public void setUpTest() {
    // creating mocks
    jpaRoleDAOImpl = mock(JpaRoleDAOImpl.class);
    //unchecked assignment
    roles = mock(List.class);
    role = mock(Role.class);
    users = mock(List.class);
  }

  @Test
  public void getByIdTest() {
    when(jpaRoleDAOImpl.getById(id)).thenReturn(role);
    assertEquals(jpaRoleDAOImpl.getById(id),role);
  }

  @Test
  public void findByNameTest() {
    when(jpaRoleDAOImpl.findByName(role.getName())).thenReturn(role);
    assertEquals(jpaRoleDAOImpl.findByName(role.getName()),role);
  }

  @Test
  public void getAllTest() {
    when(jpaRoleDAOImpl.getAll()).thenReturn(roles);
    assertEquals(jpaRoleDAOImpl.getAll(),roles);
  }

  @Test
  @Transactional
  public void saveTest() {
    doThrow(new RuntimeException("saveTest Exception")).when(jpaRoleDAOImpl).save(role);
  }

  @Test
  public void deleteTest() {
  doThrow(new RuntimeException("deleteTest Exception")).when(jpaRoleDAOImpl).delete(role);
  }

}
