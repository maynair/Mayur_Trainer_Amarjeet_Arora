package com.dao;

import java.util.List;

import com.model.Cart;
import com.model.CustomerOrder;

public interface CustomerOrderDao {

	void addCustomerOrder(CustomerOrder customerOrder);
	List<CustomerOrder> getAllCustomerOrder(String email);

	/* CustomerOrder getCustomerOrderBycart(Cart cart); */
	List<CustomerOrder> getAllCustomerOrder();	
	CustomerOrder getCustomerOrderById(String customerOrderId);	
	void deleteCustomerOrderById(String customerOrderId);
	
}
