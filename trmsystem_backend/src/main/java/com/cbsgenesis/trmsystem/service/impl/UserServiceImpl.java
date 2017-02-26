package com.cbsgenesis.trmsystem.service.impl;

import com.cbsgenesis.trmsystem.dao.RoleDAO;
import com.cbsgenesis.trmsystem.dao.UserDAO;
import com.cbsgenesis.trmsystem.model.Role;
import com.cbsgenesis.trmsystem.model.User;
import com.cbsgenesis.trmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Implementation of {@link UserService} interface
 *
 * @author Eugene Suleimanov
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private RoleDAO roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findByName("ROLE_USER"));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    @Transactional
    public User getById(UUID id) {
        User user = userDao.getById(id);
        return user;
    }

    @Override
    @Transactional
    public User findByUserName(String username) {
        return userDao.findByName(username);
    }

    @Override
    @Transactional
    public Collection<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public void delete(User user) {
        this.userDao.delete(user);
    }

    @Override
    public boolean coincidencePassword(CharSequence rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}