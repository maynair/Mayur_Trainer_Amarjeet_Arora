package com.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.BillingAddress;

@Repository

public interface BillingAddressDao{
	
	void addBillingAddress(BillingAddress billingAddress);
	
	 BillingAddress getBillingAddressbyId(String billingAddressId) ;	 
}
