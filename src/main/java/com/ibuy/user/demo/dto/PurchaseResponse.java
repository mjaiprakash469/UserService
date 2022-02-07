package com.ibuy.user.demo.dto;

public class PurchaseResponse {

	private String message;
	private int purchaseId;
	public PurchaseResponse(String message, int purchaseId) {
		super();
		this.message = message;
		this.purchaseId = purchaseId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	
}
