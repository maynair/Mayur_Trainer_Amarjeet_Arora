package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Authorities;
import com.model.BillingAddress;
import com.model.Cart;
import com.model.Customer;
import com.model.User;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	   @Override
	public void addCustomer(Customer customer) {
		System.out.println("Adding customer in dao");
		Session session = sessionFactory.openSession();
		// customer - has users,shippingaddress
		// insert the users,billingaddress
		customer.getUsers().setEnabled(true);

		Authorities authorities = new Authorities();
		authorities.setAuthorities("ROLE_USER");
		authorities.setEmailId(customer.getUsers().getEmailId());

		Cart cart = new Cart();
		// it is to set CartId for customer table
		customer.setCart(cart);// set the cart to the customer
		// if we omit this statement, hen it will insert null for customerid in cart
		// to set the customerid in cart table
		cart.setCustomer(customer);
		session.save(customer);
		session.save(authorities);
		session.flush();
		session.close();
	}

	   @Override
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		return customerList;
	}
	
    @Override
	public Customer getCustomerById(String customerId) {
		/*
		 * Session session = sessionFactory.openSession(); Query query =
		 * session.createQuery("from Customer where customerId=?"); query.setString(0,
		 * customerId); User users = (User)query.uniqueResult(); Customer customer =
		 * users.getCustomer(); return customer;
		 */
		Session session = sessionFactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, customerId);
		session.close();
		return customer;
	}

	@Override
	public Customer getCustomerByemailId(String emailId) {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where emailId=?");
		query.setString(0, emailId);
		User users = (User) query.uniqueResult();
		Customer customer = users.getCustomer();
		return customer;

		/*
		 * Session session = sessionFactory.openSession(); Customer customer =
		 * (Customer) session.get(Customer.class, emailId); session.close(); return
		 * customer;
		 */
	}

	@Override
	public Customer findCustomerByusernameAndpassword(String username, String password) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where username=? and password =?");
		query.setString(0, username);
		query.setString(1, password);
		User users = (User) query.uniqueResult();
		Customer customer = users.getCustomer();
		return customer;
	}

}
