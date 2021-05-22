package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ShippingAddressDao;
import com.model.ShippingAddress;
import com.service.ShippingAddressService;

@Service

public class ShippingAddressServiceImpl implements ShippingAddressService{

	@Autowired
	private ShippingAddressDao shippingAddressDao;
	@Transactional()
	@Override
	public void addShippingAddress(ShippingAddress shippingAddress) {
		
		shippingAddressDao.addShippingAddress(shippingAddress);		
	}
	
	@Transactional(readOnly = true)
	@Override
	public ShippingAddress getShippingAddressById(String shippingAddressId) {
		
		return shippingAddressDao.getShippingAddressById(shippingAddressId);
	}

}
