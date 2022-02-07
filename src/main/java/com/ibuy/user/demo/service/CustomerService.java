package com.ibuy.user.demo.service;

import com.ibuy.user.demo.entity.Customer;
import java.util.List;
public interface CustomerService {
	List<Customer> findAll();

	Customer findOne(String email);
}
