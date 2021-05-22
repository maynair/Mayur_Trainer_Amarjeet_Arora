package com.service;

import java.util.List;

import com.model.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerById(String customerId);
	
	Customer getCustomerByEmailId(String emailId);

	Customer findCustomerByusernameAndpassword(String username, String password);

}
