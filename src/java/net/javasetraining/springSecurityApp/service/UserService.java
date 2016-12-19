package net.javasetraining.springSecurityApp.service;

import net.javasetraining.springSecurityApp.model.User;

/**
 * Service class for{@link net.javasetraining.springSecurityApp.model.User}
 * @author MaRV
 */
public interface UserService {

    void save(User user);
    org.springframework.security.core.userdetails.User findByUsername(String username);


}
