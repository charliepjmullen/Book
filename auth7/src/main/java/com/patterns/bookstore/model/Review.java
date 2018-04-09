package com.patterns.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {

	private Long id;
	private String username;
	private String  book_title;
	private String comment;
	
	public Review() {
	}
	
	public Review(Long id, String username, String book_title, String comment) {
		this.id = id;
		this.username = username;
		this.comment = comment;
		this.book_title = book_title;
	}
	
	public Review( String username, String  book_title, String comment) {
		this.username = username;
		this.comment = comment;
		this.book_title = book_title;
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

	public String getBook_title() {
		return book_title;
	}

	public void setBook_id(String  book_title) {
		this.book_title = book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	
	
	
	
    
    
}
