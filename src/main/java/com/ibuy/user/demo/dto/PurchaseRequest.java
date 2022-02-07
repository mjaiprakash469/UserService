package com.ibuy.user.demo.dto;

public class PurchaseRequest {

	private int cartId;

	public PurchaseRequest(int cartId) {
		super();
		this.cartId = cartId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
}

