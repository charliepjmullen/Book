package com.patterns.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patterns.bookstore.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
