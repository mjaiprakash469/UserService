package com.ibuy.user.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int purchaseId;
	
	private int customerId;
	private int productId;
	private double amount;
	private LocalDateTime purchasedDate;
	
	public Purchase() {
		
	}
	
	public Purchase(int customerId, int productId, double amount, LocalDateTime purchasedDate) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.amount = amount;
		this.purchasedDate = purchasedDate;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(LocalDateTime purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	
	
}
