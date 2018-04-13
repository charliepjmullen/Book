package com.patterns.bookstore.web;

import com.patterns.bookstore.purchasingFacade.OrderServiceFacade;

public class OrderProcessController {

	OrderServiceFacade facade;
    boolean orderFulfilled=false;
    
    public void orderProduct(Long id) {
        orderFulfilled=facade.placeOrder(id);
        //System.out.println("OrderFulfillmentController: Order fulfillment completed. ");
    }

}
