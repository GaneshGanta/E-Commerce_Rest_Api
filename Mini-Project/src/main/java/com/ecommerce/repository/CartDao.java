package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{
   

	
}
