package com.ecommerce.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	
	public Customer findByEmail(String email);

	@Query("select a.Customer from Address a where a.city=?1")
	List<Customer> viewAllCustomer(String location);

}
