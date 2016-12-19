package net.javasetraining.springSecurityApp.service;

/**
 * Service for security.
 */
public interface SecurityService {
String findLoggedInUsers();
 void autoLogin(String username, String password);

}
