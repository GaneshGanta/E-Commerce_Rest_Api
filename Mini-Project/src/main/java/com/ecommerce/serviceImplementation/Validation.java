package com.ecommerce.serviceImplementation;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.model.CurrentUserSession;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.CustomerDao;
import com.ecommerce.repository.UserSessionDao;


@org.springframework.stereotype.Service
public class Validation {
	
	@Autowired
	private UserSessionDao currentuser;
	
	@Autowired
	private CustomerDao custDao;
	
	
	public Customer validateLogin(String key) throws LoginException,CustomerException{
		
		CurrentUserSession checkCustomer = currentuser.findByUuid(key);
		
		if(checkCustomer == null) throw new LoginException("Customer not logged in");
		
		Customer loggedCustomer  = custDao.findById(checkCustomer.getUserId()).orElseThrow(()-> new CustomerException("No Such Customer in Db"));
		
		return loggedCustomer;

		
		             
		             
		             
		
		
		
	}

}
