package com.ibuy.user.demo.dto;

public class CartResponse {

	private String message;
	private int cartId;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public CartResponse(String message, int cartId) {
		super();
		this.message = message;
		this.cartId = cartId;
	}
	
}
