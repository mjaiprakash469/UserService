package com.ibuy.user.demo.dto;

public class CartResponse {

	private String message;
	private int productId;
	private int quantity;
	
	
	
	public CartResponse(String message, int productId, int quantity) {
		super();
		this.message = message;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
