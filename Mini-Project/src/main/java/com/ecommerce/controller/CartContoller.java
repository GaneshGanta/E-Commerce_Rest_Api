package com.ecommerce.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.ProductDto;
import com.ecommerce.service.CartServices;


@RestController
@RequestMapping(value="/cart")
public class CartContoller {
	
	@Autowired
	public CartServices Cservice;
	
	@PostMapping("/add/{pid}/{q}/{key}")
	public ResponseEntity<Cart>addProductToCartHandler(@PathVariable("pid") Integer pid,@PathVariable("q") Integer quantity,@PathVariable("key") String key ) throws LoginException, CustomerException, ProductException
	{
		Cart updatedCart = Cservice.addProductToCart(pid,quantity,  key);
		
		return new ResponseEntity<Cart>(updatedCart,HttpStatus.ACCEPTED);
	}
	
	

	
	@GetMapping("/view/{key}") 
	public ResponseEntity<List<ProductDto>>viewAllProducts(@PathVariable("key") String key) throws LoginException, CustomerException,ProductException{
		         List<ProductDto> productlist = Cservice.viewAllProductsFromCart(key);
		         
		return new ResponseEntity<List<ProductDto>>(productlist,HttpStatus.OK);
	}
	
	@GetMapping("/total/{key}")
	
	public ResponseEntity<Integer> CartContoller(@PathVariable("key") String key) throws LoginException, CustomerException, ProductException{
		double cartTotal =  Cservice.cartTotal(key);
		return new  ResponseEntity<Integer>((int) cartTotal,HttpStatus.OK);
	}

}
