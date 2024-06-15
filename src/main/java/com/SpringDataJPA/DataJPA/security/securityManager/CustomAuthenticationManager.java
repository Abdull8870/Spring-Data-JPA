package com.SpringDataJPA.DataJPA.security.securityManager;

import com.SpringDataJPA.DataJPA.entity.User;
import com.SpringDataJPA.DataJPA.services.serviceImplementation.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.CustomLog;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    private UserServiceImpl userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username=authentication.getName();
        String password= authentication.getCredentials().toString();
        User userByUsername = this.userService.findUserByUsername(username);
        if(!bCryptPasswordEncoder.matches(password,userByUsername.getPassword())){
           throw new BadCredentialsException("Invalid Password");
        }

        return new UsernamePasswordAuthenticationToken(username,password);
    }
}
