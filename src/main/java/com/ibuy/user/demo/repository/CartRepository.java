package com.ibuy.user.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibuy.user.demo.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>,CrudRepository<Cart, Integer>{

	Optional<Cart> findByCartId(int cartId);
}

