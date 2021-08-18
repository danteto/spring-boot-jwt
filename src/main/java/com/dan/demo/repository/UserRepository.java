package com.dan.demo.repository;

import com.dan.demo.model.User;

public interface UserRepository {
    boolean existsByUsername(String username);

    User findByUsername(String username);

    void save(User user);
}
