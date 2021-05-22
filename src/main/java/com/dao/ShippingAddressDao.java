package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.ShippingAddress;
import com.model.User;

public interface ShippingAddressDao {
	
    void addShippingAddress(ShippingAddress shippingAddress);
	
	ShippingAddress getShippingAddressById(String shippingAddressId);

}
