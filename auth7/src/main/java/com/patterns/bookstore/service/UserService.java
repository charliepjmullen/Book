package com.patterns.bookstore.service;

import com.patterns.bookstore.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
