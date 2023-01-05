package com.ecommerce.serviceImplementation;

import com.ecommerce.exception.LoginException;
import com.ecommerce.model.User;

public interface LoginService {
	
	public String LoginYourAccount(User user) throws LoginException;
	public String LogoutYourAccount(String key) throws LoginException;

	
}
