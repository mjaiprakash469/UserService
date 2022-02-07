package com.ibuy.user.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibuy.user.demo.dto.AuthToken;
import com.ibuy.user.demo.dto.AuthenticationRequest;
import com.ibuy.user.demo.entity.Customer;
import com.ibuy.user.demo.exception.InvalidUserCredentials;
import com.ibuy.user.demo.service.CustomerService;
import com.ibuy.user.demo.util.JwtTokenUtil;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> register(@RequestBody @Valid AuthenticationRequest users) {	
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getEmail(), users.getPassword()));
		 final Customer user = customerService.findOne(users.getEmail());
	        final String token = jwtTokenUtil.generateToken(user);
	       return new ResponseEntity<>(new AuthToken(token, user.getEmail()), HttpStatus.OK);
		}catch (AuthenticationException e) {
			throw new InvalidUserCredentials("Invaild Credentials");
			
		}
				
	    }

}
