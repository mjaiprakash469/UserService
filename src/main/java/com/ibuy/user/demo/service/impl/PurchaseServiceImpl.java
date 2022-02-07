package com.ibuy.user.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.ibuy.user.demo.dto.HistoryRepsonse;
import com.ibuy.user.demo.dto.PurchaseResponse;
import com.ibuy.user.demo.entity.Customer;
import com.ibuy.user.demo.entity.Purchase;
import com.ibuy.user.demo.exception.PurchaseItenNotFoundException;
import com.ibuy.user.demo.feignclient.ProductClient;
import com.ibuy.user.demo.repository.CustomerRepository;
import com.ibuy.user.demo.repository.PurchaseRepository;
import com.ibuy.user.demo.service.PurchaseService;
import com.ibuy.user.demo.util.JwtTokenUtil;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	CustomerRepository usersRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	PurchaseRepository productRepository;
	
	@Autowired
	ProductClient productClient;
	
	@Autowired
	JwtTokenUtil jwtUtil;
	
	
	@Override
	public List<HistoryRepsonse> getPurchaseHistory(String token,int pageSize) throws PurchaseItenNotFoundException{
		String username=jwtUtil.getUsernameFromToken(token);
		Optional<Customer> customer=usersRepository.findByEmail(username);
		int pageNumber =0;
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.DESC, "purchaseId"));
		Customer customerDetails=customer.get();
		List<Purchase> getPurchaseList = purchaseRepository.findByCustomerId(customerDetails.getCustomerId(),pageable);
		if(getPurchaseList.isEmpty()) {
			throw new PurchaseItenNotFoundException("Purchase items not found");
		}
		List<HistoryRepsonse> historyDetails=new ArrayList<HistoryRepsonse>();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		getPurchaseList.stream().forEach((p)->historyDetails.add(new HistoryRepsonse(p.getPurchaseId(), 
				productClient.getProduct(p.getProductId()).get().getProductName(), 
				p.getAmount(), p.getPurchasedDate().format(formatter))));
			return historyDetails;
	}

}
