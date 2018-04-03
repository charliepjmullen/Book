package com.patterns.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {

	private Long id;
	private String username;
	private Long book_id;
	private String comment;
	
	public Review() {
	}
	
	public Review(Long id, String username, Long book_id, String comment) {
		this.id = id;
		this.username = username;
		this.comment = comment;
		this.book_id = book_id;
	}
	
	public Review( String username, Long book_id, String comment) {
		this.username = username;
		this.comment = comment;
		this.book_id = book_id;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	
	
    
    
}
