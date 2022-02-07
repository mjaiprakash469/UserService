package com.ibuy.user.demo.feignclient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibuy.user.demo.dto.ProductResponse;

@FeignClient(value="product-service", url="http://localhost:8082")
public interface ProductClient {

	@GetMapping("/products/{id}")
	public Optional<ProductResponse> getProduct(@PathVariable int id);
}
