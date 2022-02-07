package com.ibuy.user.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ibuy.user.demo.dto.PurchaseRequest;
import com.ibuy.user.demo.dto.PurchaseResponse;
import com.ibuy.user.demo.service.CustomerService;
import com.ibuy.user.demo.util.JwtTokenUtil;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;	
	
	@PostMapping("/orders")
	public ResponseEntity<PurchaseResponse> purchase(@RequestHeader(name="Authorization") String token,@RequestBody PurchaseRequest request){
		
		return customerService.purchase(token, request);
	}
	
	@GetMapping("/history{pageSize}")
	public List<Purchase> getPurchaseHistory(@PathVariable int pageSize){
		return purchaseService.getPurchaseHistory(pageSize);
	}
	
}
