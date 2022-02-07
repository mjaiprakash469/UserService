package com.ibuy.user.demo.dto;

public class ProductResponse {

	private long productId;
	private String name;
	private String make;
	private String description;
	private double price;
	private int discount;
	public long getProductId() {
		return productId;
	}
	
	
	
	public ProductResponse(long productId, String name, String make, String description, double price, int discount) {
		super();
		this.productId = productId;
		this.name = name;
		this.make = make;
		this.description = description;
		this.price = price;
		this.discount = discount;
	}



	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
