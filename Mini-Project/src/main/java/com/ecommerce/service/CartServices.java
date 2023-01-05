package com.ecommerce.service;


import java.util.List;


import org.springframework.stereotype.Service;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.ProductDto;




@Service
public interface CartServices {

   
//	public ProductDto updateProductQuantity( Integer pid, Integer quantity, String key) throws CustomerException, LoginException ;
//	
//	public Cart addProductToCart(Integer pid,  Integer quantity, String key) throws CustomerException, LoginException, ProductException;
	
	public Cart addProductToCart(Integer pid,  Integer quantity, String key) throws CustomerException, LoginException, ProductException;
	
	public List<ProductDto> viewAllProductsFromCart(String key) throws CustomerException, LoginException, ProductException;
	
	public double cartTotal(String key)throws CustomerException, LoginException, ProductException;
	
	}

	

