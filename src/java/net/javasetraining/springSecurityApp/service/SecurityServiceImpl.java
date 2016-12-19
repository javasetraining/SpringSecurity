package net.javasetraining.springSecurityApp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

/**
 * Implimentetion ov{@link SecurityService}
 */
@Service
public class SecurityServiceImpl implements SecurityService{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public String findLoggedInUsers() {
        return null;
    }

    @Override
    public void autoLogin(String username, String password) {

    }
}
