package com.patterns.bookstore.service;

import com.patterns.bookstore.model.Book;

public interface BookService {

	void save(Book book);
	
	Book findBookById(Long id);
}
