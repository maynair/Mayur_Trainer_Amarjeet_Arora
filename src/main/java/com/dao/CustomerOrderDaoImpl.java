package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Cart;
import com.model.Customer;
import com.model.CustomerOrder;
import com.model.Product;
import com.model.User;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCustomerOrder(CustomerOrder customerOrder) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(customerOrder);
		session.flush();
		session.close();
	}

	public List<CustomerOrder> getAllCustomerOrder(String email) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "FROM customeroder WHERE emailId ='" + email + "'";
		@SuppressWarnings("unchecked")
		List<CustomerOrder> results = session.createQuery(hql).list();
		return results;
	}

	/*
	 * @Override public CustomerOrder getCustomerOrderBycart(Cart cart) { // TODO
	 * Auto-generated method stub return null; }
	 */

	@Override
	public List<CustomerOrder> getAllCustomerOrder() {
		Session session = sessionFactory.openSession();
		List<CustomerOrder> customerOrder = session.createCriteria(CustomerOrder.class).list();
		System.out.println(customerOrder);
		session.close();
		return customerOrder;
	}

	@Override
	public CustomerOrder getCustomerOrderById(String customerOrderId) {
		Session session = sessionFactory.openSession();
		CustomerOrder customerOrder = (CustomerOrder) session.get(CustomerOrder.class, customerOrderId);
		session.close();
		return customerOrder;
	}

	@Override
	public void deleteCustomerOrderById(String customerOrderId) {
		Session session = sessionFactory.openSession();
		CustomerOrder customeroder = (CustomerOrder) session.get(CustomerOrder.class, customerOrderId);
		session.delete(customeroder);
		session.flush();
		session.close();
	}

}
