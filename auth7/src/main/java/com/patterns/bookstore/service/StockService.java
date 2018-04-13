package com.patterns.bookstore.service;

import com.patterns.bookstore.model.Book;

// Stock control in the facade pattern
public class StockService {

public static boolean isAvailable(Book book) {
		
		boolean available = false;
		
		if (book.getQuantity() > 0) {
			available = true;
			//System.out.println(book.getTitle() + " is available");
		} else if (book.getQuantity()== 0){
			available = false;
			//System.out.println(book.getTitle() + " is out of stock");
		}
		return available;
	}

}
