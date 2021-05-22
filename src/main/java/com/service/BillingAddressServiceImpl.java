package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BillingAddressDao;
import com.model.BillingAddress;
import com.service.BillingAddressService;

@Service

public class BillingAddressServiceImpl implements BillingAddressService{

	@Autowired
	private BillingAddressDao billingAddressDao;
	
	//persisting and deleting objects requires a transaction in JPA. Thus we need to make sure a transaction is running, which we do by having the method annotated with @Transactional.
	@Transactional()
	@Override
	public void addBillingAddress(BillingAddress billingAddress) {
		
		billingAddressDao.addBillingAddress(billingAddress);
		
	}

	@Transactional(readOnly = true)
	@Override
	public BillingAddress getBillingAddressbyId(String billingAddressId) {
		
		return billingAddressDao.getBillingAddressbyId(billingAddressId);
	}

}
