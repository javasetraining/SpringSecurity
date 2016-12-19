package net.javasetraining.springSecurityApp.service;

import javafx.scene.input.KeyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.javasetraining.springSecurityApp.dao.RoleDao;
import net.javasetraining.springSecurityApp.dao.UserDao;
import net.javasetraining.springSecurityApp.model.Role;
import net.javasetraining.springSecurityApp.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implements of {@link UserService} interface
 *
 * @author MaRV on 12/18/2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
