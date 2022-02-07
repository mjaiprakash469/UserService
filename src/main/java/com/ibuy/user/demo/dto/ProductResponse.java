package com.ibuy.user.demo.dto;

public class ProductResponse {

	private int productId;
	private String productName;
	private String make;
	private String description;
	private double price;
	private int discount;
	public int getProductId() {
		return productId;
	}
	
	
	
	public ProductResponse(int productId, String productName, String make, String description, double price, int discount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.make = make;
		this.description = description;
		this.price = price;
		this.discount = discount;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
}
