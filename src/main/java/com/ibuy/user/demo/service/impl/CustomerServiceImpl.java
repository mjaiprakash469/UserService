package com.ibuy.user.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ibuy.user.demo.dto.PurchaseRequest;
import com.ibuy.user.demo.dto.PurchaseResponse;
import com.ibuy.user.demo.entity.Cart;
import com.ibuy.user.demo.entity.Customer;
import com.ibuy.user.demo.entity.Purchase;
import com.ibuy.user.demo.exception.InvalidUserCredentials;
import com.ibuy.user.demo.repository.CartRepository;
import com.ibuy.user.demo.repository.CustomerRepository;
import com.ibuy.user.demo.repository.PurchaseRepository;
import com.ibuy.user.demo.service.CustomerService;
import com.ibuy.user.demo.util.JwtTokenUtil;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService,UserDetailsService{

	@Autowired
	CustomerRepository usersRepository;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	PurchaseRepository purchaseRepo;
	
	@Autowired
	JwtTokenUtil jwtUtil;
	
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
	
	@Override
	public ResponseEntity<PurchaseResponse> purchase(String token,PurchaseRequest request){
		String username=jwtUtil.getUsernameFromToken(token);
		Optional<Customer> customer=usersRepository.findByEmail(username);
		Customer customerDetails=customer.get();
		Optional<Cart> cartValue=cartRepo.findByCartId(request.getCartId());
		if(!cartValue.isPresent()) {
			return new ResponseEntity<PurchaseResponse>(new PurchaseResponse("Cart Id not avilable",0),HttpStatus.NOT_FOUND);
		}
		else {
			Cart cart=cartValue.get();
			if(cart.getAmount()>customerDetails.getBalance()) {
				return new ResponseEntity<PurchaseResponse>(new PurchaseResponse("Insuffiecent funds for purchase",0),
						HttpStatus.NOT_FOUND);
			}
			else {
				LocalDateTime date=LocalDateTime.now();
				Purchase p=new Purchase(customerDetails.getCustomerId(), cart.getProductId(), cart.getAmount(), date);
				purchaseRepo.save(p);
				cartRepo.deleteById(request.getCartId());
				return new ResponseEntity<PurchaseResponse>(new PurchaseResponse("Product purchased successfully",
						p.getPurchaseId()),HttpStatus.OK);
			} 
		}
	}
		

}
