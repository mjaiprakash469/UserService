package com.ibuy.user.demo.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibuy.user.demo.entity.Customer;
import com.ibuy.user.demo.exception.InvalidUserCredentials;
import com.ibuy.user.demo.repository.CustomerRepository;
import com.ibuy.user.demo.util.JwtTokenUtil;

@ExtendWith(SpringExtension.class)
public class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	@Mock
	CustomerRepository customerRepo;
	
	@Mock
	JwtTokenUtil jwtTokenUtil;
	
	@Test
	public void testLoadUserByUsernameForSuccess() throws InvalidUserCredentials {
		
		Customer customer = new Customer();
		customer.setEmail("abc@abc.com");
		Mockito.when(customerRepo.findByEmail("abc@abc.com")).thenReturn(Optional.of(customer));
		Customer customer1 = (Customer) customerServiceImpl.loadUserByUsername("abc@abc.com");
		assertNotEquals(customer1,customer );
		
		
	}
	
	@Test
	public void testLoadUserByUsernameFoeException() throws InvalidUserCredentials {
		
		Customer customer = new Customer();
		customer.setEmail("abc@abc.com");
		Mockito.when(customerRepo.findByEmail("abc@abc.com")).thenReturn(Optional.of(customer));
		Customer customer1 = (Customer) customerServiceImpl.loadUserByUsername("abcd@abc.com");
		assertThrows(InvalidUserCredentials.class, () -> {
		customerServiceImpl.loadUserByUsername("abcd@abc.com");});
		
	}
	
	public void testPurchase() {
		
		
	}
}
