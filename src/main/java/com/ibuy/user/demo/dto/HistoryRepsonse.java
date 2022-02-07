package com.ibuy.user.demo.dto;

public class HistoryRepsonse {

	private int purchaseId;
	private String productName;
	private double amount;
	private String date;
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public HistoryRepsonse(int purchaseId, String productName, double amount, String date) {
		super();
		this.purchaseId = purchaseId;
		this.productName = productName;
		this.amount = amount;
		this.date = date;
	}
	
}
