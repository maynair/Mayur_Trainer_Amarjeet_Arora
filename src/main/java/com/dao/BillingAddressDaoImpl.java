package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.BillingAddress;


@Repository
@Transactional
public class BillingAddressDaoImpl implements BillingAddressDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addBillingAddress(BillingAddress billingAddress) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(billingAddress);
		session.flush();
		session.close();
	}

	@Override
	public BillingAddress getBillingAddressbyId(String billingAddressId) {
		Session session = sessionFactory.openSession();
		BillingAddress billingAddress = (BillingAddress) session.get(BillingAddress.class, billingAddressId);
		System.out.println(billingAddress);
		session.close();
		return billingAddress;
	}

	
}
