package com.ibuy.user.demo.service;

import java.util.List;

import com.ibuy.user.demo.entity.Purchase;


public interface PurchaseService {

	List<Purchase> getPurchaseHistory(int pageSize);

	

}
