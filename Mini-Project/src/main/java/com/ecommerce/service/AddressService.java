package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.model.Address;



public interface AddressService {
	public Address addAddres(Address address,String key) throws LoginException, CustomerException;
	public Address updateAddress(Address address,String key) throws LoginException, CustomerException;
	public Address removeAddress( String key) throws LoginException, CustomerException;
	public List<Address> viewAllAddress();
	public Address viewAddressByUserId(Integer userId) throws CustomerException;

}
