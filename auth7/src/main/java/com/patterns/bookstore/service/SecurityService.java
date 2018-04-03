package com.patterns.bookstore.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
