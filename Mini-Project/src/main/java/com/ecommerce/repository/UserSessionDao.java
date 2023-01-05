package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.CurrentUserSession;


public interface UserSessionDao extends JpaRepository<CurrentUserSession, Integer>{
	
	public CurrentUserSession findByUuid(String uuid);

}
