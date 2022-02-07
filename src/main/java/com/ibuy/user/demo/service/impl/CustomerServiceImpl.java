package com.ibuy.user.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ibuy.user.demo.entity.Customer;
import com.ibuy.user.demo.exception.InvalidUserCredentials;
import com.ibuy.user.demo.repository.CustomerRepository;
import com.ibuy.user.demo.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService,UserDetailsService{

	@Autowired
	CustomerRepository usersRepository;
	
	private final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);


	public UserDetails loadUserByUsername(String email){
		Optional<Customer> user = usersRepository.findByEmail(email);
		if(user.isPresent()){
			Customer userInfo = user.get();
			return new org.springframework.security.core.userdetails.User(userInfo.getEmail(), userInfo.getPassword(), getAuthority());
		}else {
			logger.error("Invalid username or password");
			throw new InvalidUserCredentials("Invalid username or password.");
		}
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<Customer> findAll() {
		List<Customer> list = new ArrayList<>();
		usersRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}


	@Override
	public Customer findOne(String email) {
		Optional<Customer> user = usersRepository.findByEmail(email);
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}

}
