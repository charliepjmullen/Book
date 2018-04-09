package com.patterns.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patterns.bookstore.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
