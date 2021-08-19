package com.dan.demo.repository;

import com.dan.demo.model.Role;
import com.dan.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {

    private List<User> users;

    public UserRepositoryImpl() {
        users = new ArrayList<>();
        User user = new User("admin", "$2a$12$wSn1YHDFIyVUpZtUcpD1A.jRTjguO0u4WyckTFjzJFzQtTM7.07OW", Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_CLIENT));
        users.add(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) return true;
        }

        return false;
    }

    @Override
    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }

        }

        return null;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
}
