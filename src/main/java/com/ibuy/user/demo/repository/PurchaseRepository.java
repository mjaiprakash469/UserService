package com.ibuy.user.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibuy.user.demo.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

}
