package com.dao;

import java.util.List;

import com.model.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);

	Customer getCustomerById(String customerId);

	Customer findCustomerByusernameAndpassword(String username, String password);

}
