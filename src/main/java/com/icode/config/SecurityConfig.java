package com.icode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> userList = new ArrayList<UserDetails>();
        userList.add(new User("admin", encoder.encode("admin"), List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))));
        userList.add(new User("manager", encoder.encode("manager"), List.of(new SimpleGrantedAuthority("ROLE_MANAGER"))));
        return new InMemoryUserDetailsManager(userList);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()

                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/project/**").hasRole("MANAGER")
                .antMatchers("/task/employee/**").hasRole("EMPLOYEE")

                //   .antMatchers("/task/**").hasAnyAuthority("ROLE_EMPLOYEE")
                //    .antMatchers("/task/**").hasAnyRole("EMPLOYEE","ADMIN")

                .antMatchers(
                        "/",
                        "/login",
                        "/fragments/**",
                        "/assets/**",
                        "/images/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //         .httpBasic()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/welcome")
                    .failureUrl("/login?error=true")
                    .permitAll()

                .and()
                .build();
    }
}
