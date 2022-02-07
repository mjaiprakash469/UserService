package com.ibuy.user.demo.service;

import com.ibuy.user.demo.dto.PurchaseRequest;
import com.ibuy.user.demo.dto.PurchaseResponse;
import com.ibuy.user.demo.entity.Customer;
import java.util.List;

import org.springframework.http.ResponseEntity;
public interface CustomerService {
	List<Customer> findAll();

	Customer findOne(String email);
	
	ResponseEntity<PurchaseResponse> purchase(String token, PurchaseRequest request);
}
