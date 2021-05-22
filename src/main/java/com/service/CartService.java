package com.service;

import com.model.Cart;

public interface CartService {

	Cart getCartByCartId(String CartId);

	void addCart(Cart cart);
}
