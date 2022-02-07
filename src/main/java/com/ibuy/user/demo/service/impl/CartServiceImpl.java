package com.ibuy.user.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibuy.user.demo.dto.CartRequest;
import com.ibuy.user.demo.dto.CartResponse;
import com.ibuy.user.demo.dto.ProductResponse;
import com.ibuy.user.demo.entity.Cart;
import com.ibuy.user.demo.entity.Customer;
import com.ibuy.user.demo.exception.CartNotAvailableException;
import com.ibuy.user.demo.exception.InvalidUserCredentials;
import com.ibuy.user.demo.exception.ProductNotFountException;
import com.ibuy.user.demo.feignclient.ProductClient;
import com.ibuy.user.demo.repository.CartRepository;
import com.ibuy.user.demo.repository.CustomerRepository;
import com.ibuy.user.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	ProductClient productClient;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CartResponse updateCart(CartRequest request, int cartId, String email) throws CartNotAvailableException {
		Optional<ProductResponse> proOptional = Optional.of(productClient.getProduct(request.getProductId()));
		if (proOptional.isPresent()) {
			double price = proOptional.get().getPrice();
			Optional<Cart> cartOptional = cartRepository.findById(cartId);
			if (cartOptional.isPresent() && cartOptional.get().getQuantity() > 0) {
				Cart cart = cartOptional.get();
				cart.setCartId(cartId);
				cart.setAmount(price * request.getQuantity());
				cart.setCustomerId(getUserId(email));
				cart.setProductId(request.getProductId());
				cart.setQuantity(request.getQuantity());
				cartRepository.save(cart);
				return new CartResponse("Cart Updateted Successfully", request.getProductId(), request.getQuantity());
			} else if (cartOptional.isPresent() && cartOptional.get().getQuantity() == 0) {
				cartRepository.deleteById(cartId);
			}

			throw new CartNotAvailableException("No Cart Available");
		}
		throw new ProductNotFountException("Product Not Found exception");
	}
	
	public int getUserId(String email) {
		Optional<Customer> optCustomer = customerRepository.findByEmail(email);
		if (optCustomer.isPresent()) {
			return optCustomer.get().getCustomerId();
		} else {
			throw new InvalidUserCredentials("User Not found");
		}

	}

}
