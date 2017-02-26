package com.cbsgenesis.trmsystem.service;

/**
 * Service for security purposes.
 *
 * @author Eugene Suleimanov
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
