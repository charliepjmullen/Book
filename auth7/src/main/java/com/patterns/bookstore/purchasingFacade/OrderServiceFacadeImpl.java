package com.patterns.bookstore.purchasingFacade;

import com.patterns.bookstore.model.Book;
import com.patterns.bookstore.service.PurchasingService;
import com.patterns.bookstore.service.StockService;



public class OrderServiceFacadeImpl implements OrderServiceFacade{

	public OrderServiceFacadeImpl() {
		// TODO Auto-generated constructor stub
	}
	
	StockService stockService;
	
	PurchasingService purchasingService;

	@Override
	public boolean placeOrder(Long id) {
		boolean orderFulfilled = false;
		Book book = new Book();
		id = book.getId();
		
		if(StockService.isAvailable(book)) {
			System.out.println("Product with ID: "+ book.getId()+" is available.");
            boolean paymentConfirmed= PurchasingService.makePayment();
            if(paymentConfirmed){
                System.out.println("Payment confirmed...");
                orderFulfilled=true;
            }
		}
		return orderFulfilled;
	}

}
