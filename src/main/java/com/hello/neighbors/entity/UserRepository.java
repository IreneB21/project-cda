package com.hello.neighbors.entity;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository {
    User findByLogin(String login);
}
