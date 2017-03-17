package com.cbsgenesis.trmsystem.service;

import com.cbsgenesis.trmsystem.model.User;

import java.util.Collection;
import java.util.UUID;

/**
 * Service class for class {@link User}
 *
 * @author Eugene Suleimanov
 */

public interface UserService {

    void save(User user);

    User getById(UUID id);

    User findByUserName(String username);

    Collection<User> getAll();

    Collection<User> getAllSupervisors();

    void delete(User team);

    boolean coincidencePassword(CharSequence rawPassword, String encodedPassword);
}
