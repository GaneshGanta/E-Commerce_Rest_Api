package com.ecommerce.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.exception.CartException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Order;


@Service
public interface OrderService {
	
	public Order addOrder(Order order, Integer addressId, String key) throws LoginException, CustomerException, CartException, ProductException ;
	public Order updateOrder(Order order, String key) throws LoginException, CustomerException, ProductException;
	public Order removeOrder(Integer orderId, String key) throws LoginException, CustomerException;
	public Order viewOrder(Integer orderId);
	public List<Order> viewAllOrderByDate(LocalDate date);
	public List<Order> viewAllOrderByLocation(String location);
	public List<Order> viewAllOrderByUserId(Integer userid) throws CustomerException;
}
