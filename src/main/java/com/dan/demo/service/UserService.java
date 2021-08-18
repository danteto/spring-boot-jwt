package com.dan.demo.service;

import com.dan.demo.model.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    String signin(String username, String password);

    String signup(User user);

    User me(HttpServletRequest req);
}
