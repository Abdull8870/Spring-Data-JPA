package com.SpringDataJPA.DataJPA.security;

import com.SpringDataJPA.DataJPA.security.filter.AuthenticationFilter;
import com.SpringDataJPA.DataJPA.security.filter.ExceptionFilter;
import com.SpringDataJPA.DataJPA.security.filter.JWTAuthorizationFilter;
import com.SpringDataJPA.DataJPA.security.securityManager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        AuthenticationFilter authenticationFilter=new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/user/authenticate");
System.out.println("Inside");
        http.csrf((csrf)->csrf.disable()).authorizeHttpRequests((req)->
                req.requestMatchers(HttpMethod.GET,"user/users").permitAll().
                        requestMatchers(HttpMethod.POST,"user/register").
                        permitAll().anyRequest().authenticated()).
                addFilterBefore(new ExceptionFilter(),AuthenticationFilter.class).
                addFilter(authenticationFilter).
                addFilterAfter(new JWTAuthorizationFilter(),AuthenticationFilter.class).
                sessionManagement((session)->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }
}
