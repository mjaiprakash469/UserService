package com.ibuy.user.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import static com.ibuy.user.demo.constants.Constants.TOKEN_PREFIX;
import com.ibuy.user.demo.dto.CartRequest;
import com.ibuy.user.demo.dto.CartResponse;
import com.ibuy.user.demo.service.CartService;
import com.ibuy.user.demo.util.JwtTokenUtil;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@SecurityRequirement(name = "iBuy")
	@PutMapping("/cart/{cartId}")
	public ResponseEntity<CartResponse> updateCart(@RequestBody CartRequest request, @PathVariable int cartId,
			@RequestHeader(name = "Authorization") String token) {
		String userName = jwtTokenUtil.getUsernameFromToken(token.replace(TOKEN_PREFIX,""));
		CartResponse cartResponse = cartService.updateCart(request, cartId, userName);
		return new ResponseEntity<CartResponse>(cartResponse, HttpStatus.CREATED);

	}
}
