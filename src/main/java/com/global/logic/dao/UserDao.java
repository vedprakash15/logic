package com.global.logic.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {

    private static final List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "vedprksh79@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ADMIN_ROLE"))
            ),
            new User(
                    "vedprakashjava@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ADMIN_ROLE"))
            )
    );

    public UserDetails getUserByEmailId(String email) {
        return  APPLICATION_USERS
                .stream()
                .filter(user -> user.getUsername().equals(email))
                .findAny()
                .orElseThrow(() -> new UsernameNotFoundException("!!! User not found exception !!!"));
    }
}
