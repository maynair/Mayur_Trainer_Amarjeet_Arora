package com.service;

import com.model.ShippingAddress;

public interface ShippingAddressService {

	void addShippingAddress(ShippingAddress shippingAddress);
	
	ShippingAddress getShippingAddressById(String shippingAddressId);
}
