package net.javasetraining.springSecurityApp.service;

import net.javasetraining.springSecurityApp.dao.UserDao;
import net.javasetraining.springSecurityApp.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Impl of {@link org.springframework.security.core.userdetails.UserDetailsService} interface
 *
 * @Autor Marv
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userDao.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role: user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }
}
