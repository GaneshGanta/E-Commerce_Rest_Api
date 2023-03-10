package com.ecommerce.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Address;


@Repository
public interface AddressDao extends JpaRepository<Address,Integer> {

	@Query("select c.address from Customer c where c.customerId = ?1")
	public Address findByCustomerId(Integer customerId);
	
}