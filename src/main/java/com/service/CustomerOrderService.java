package com.service;

import java.util.List;
import com.model.CustomerOrder;

public interface CustomerOrderService {

	void addCustomerOrder(CustomerOrder customerOrder);
	double getCustomerOrderGrandTotal(String cartId);	

	/*
	 * CustomerOrder getCustomerOrderBycart(Cart cart);
	 */	
	List<CustomerOrder> getAllCustomerOrder();	
	CustomerOrder getCustomerOrderById(String customerOrderId);	
	void deleteCustomerOrderById(String customerOrderId);
	
}
