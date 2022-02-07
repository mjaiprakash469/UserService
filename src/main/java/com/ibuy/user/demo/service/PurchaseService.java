package com.ibuy.user.demo.service;

import java.util.List;

import com.ibuy.user.demo.dto.HistoryRepsonse;
import com.ibuy.user.demo.entity.Purchase;


public interface PurchaseService {

	List<HistoryRepsonse> getPurchaseHistory(String token,int pageSize);

	

}