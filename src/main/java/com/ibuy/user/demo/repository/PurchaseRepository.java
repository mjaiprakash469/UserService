package com.ibuy.user.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibuy.user.demo.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

	List<Purchase> findByCustomerId(int customerId,Pageable page);
}
