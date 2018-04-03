package com.patterns.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patterns.bookstore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
