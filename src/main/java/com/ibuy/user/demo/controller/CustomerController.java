package com.ibuy.user.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ibuy.user.demo.dto.CartRequest;
import com.ibuy.user.demo.dto.CartResponse;
import com.ibuy.user.demo.dto.HistoryRepsonse;
import com.ibuy.user.demo.dto.PurchaseRequest;
import com.ibuy.user.demo.dto.PurchaseResponse;
import com.ibuy.user.demo.entity.Purchase;
import com.ibuy.user.demo.service.CustomerService;
import com.ibuy.user.demo.service.PurchaseService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	PurchaseService purchaseService;
	
	@PostMapping("/orders")
	public ResponseEntity<PurchaseResponse> purchase(@RequestHeader(name="Authorization") String token,
			@RequestBody PurchaseRequest request){
		
		return customerService.purchase(token, request);
	}
	
	@GetMapping("/history/{pageSize}")
	public List<HistoryRepsonse> getPurchaseHistory(@RequestHeader(name="Authorization") String token,
			@PathVariable  int pageSize){
		return purchaseService.getPurchaseHistory(token,pageSize);
	}
	
	@PostMapping("/cart")
	public ResponseEntity<CartResponse> addProduct(@RequestHeader(name="Authorization") String token, 
			@RequestBody CartRequest request){
		return customerService.addProduct(token, request);
	}
	
}
