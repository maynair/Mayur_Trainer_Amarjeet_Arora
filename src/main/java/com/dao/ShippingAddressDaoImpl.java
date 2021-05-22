package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.ShippingAddress;


@Repository
@Transactional
public class ShippingAddressDaoImpl implements ShippingAddressDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addShippingAddress(ShippingAddress shippingAddress) {		
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(shippingAddress);
		session.flush();
		session.close();
	}

	@Override
	public ShippingAddress getShippingAddressById(String shippingAddressId) {
		Session session = sessionFactory.openSession();
		ShippingAddress shippingAddress = (ShippingAddress) session.get(ShippingAddress.class, shippingAddressId);
		System.out.println(shippingAddress);
		session.close();
		return shippingAddress;
	}

}
