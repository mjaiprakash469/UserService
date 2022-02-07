package com.ibuy.user.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.ibuy.user.demo.entity.Purchase;
import com.ibuy.user.demo.exception.PurchaseItenNotFoundException;
import com.ibuy.user.demo.feignclient.ProductClient;
import com.ibuy.user.demo.repository.PurchaseRepository;
import com.ibuy.user.demo.service.PurchaseService;

import java.util.List;



public class PurchaseServiceImpl implements PurchaseService {

	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	PurchaseRepository productRepository;
	
	@Autowired
	ProductClient productClient;
	
	
	
	@Override
	public List<Purchase> getPurchaseHistory(int pageSize) throws PurchaseItenNotFoundException{
		int pageNumber =0;
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.DESC, "purchaseId"));
		List<Purchase> getPurchaseList = purchaseRepository.findAll(pageable).getContent();
		//getPurchaseList.forEach(System.out::println);
		if(getPurchaseList.isEmpty()) {
			throw new PurchaseItenNotFoundException("Purchase items not found");
		}
			for(Purchase pr :getPurchaseList) {
				//Product na  = productRepository.findByProductId(pr.getProductId());
				//pr.setProductName(na.getProductName());
			}
			return getPurchaseList;
	}

}
