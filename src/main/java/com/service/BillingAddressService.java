package com.service;

import com.model.BillingAddress;

public interface BillingAddressService {
	
	void addBillingAddress(BillingAddress billingAddress);
	
	 BillingAddress getBillingAddressbyId(String billingAddressId) ;

}
