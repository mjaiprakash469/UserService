package com.ibuy.user.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="product-service", url="http://localhost:8082")
public interface ProductClient {

}
