package com.patterns.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.patterns.bookstore.model.UserPurchaseHistory;

public interface UserPurchaseHistoryRepository extends JpaRepository<UserPurchaseHistory, Long> {

	UserPurchaseHistory findByUsername(String username);
}
