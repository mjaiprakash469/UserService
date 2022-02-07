package com.ibuy.user.demo.service;

import com.ibuy.user.demo.dto.CartRequest;
import com.ibuy.user.demo.dto.CartResponse;

public interface CartService {

	public CartResponse updateCart(CartRequest request, int cartId, String email); 
}
