package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CustomerOrderDao;
import com.model.Cart;
import com.model.CartItem;
import com.model.CustomerOrder;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderDao customerOrderDao;
	
	@Autowired
	private CartService cartService;
	
	@Override
	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderDao.addCustomerOrder(customerOrder);
	}

	public double getCustomerOrderGrandTotal(String cartId) {
		double grandTotal=0;
		Cart cart = cartService.getCartByCartId(cartId);
		List<CartItem> cartItems = cart.getCartItem();
		
		for(CartItem item: cartItems){
			grandTotal += item.getPrice();
		}
		return grandTotal;
	}
	
	/*
	 * @Transactional(readOnly = true)
	 * 
	 * @Override public CustomerOrder getCustomerOrderBycart(Cart cart) { return
	 * customerOrderDao.getCustomerOrderBycart(cart); }
	 */
	
	@Transactional(readOnly = true)
	@Override
	public List<CustomerOrder> getAllCustomerOrder() {		
		return (List<CustomerOrder>) customerOrderDao.getAllCustomerOrder();
	}
	
	@Transactional()
	@Override
	public void deleteCustomerOrderById(String customerOrderId) {		
		customerOrderDao.deleteCustomerOrderById(customerOrderId);	
	}
	
	@Transactional(readOnly = true)
	@Override
	public CustomerOrder getCustomerOrderById(String customerOrderId) {		
		return customerOrderDao.getCustomerOrderById(customerOrderId);
	}

	/*
	 * @Override public CustomerOrder getCustomerOrderBycart(Cart cart) { // TODO
	 * Auto-generated method stub return null; }
	 */
	

}
