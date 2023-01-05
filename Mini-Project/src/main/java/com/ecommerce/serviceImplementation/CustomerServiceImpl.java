package com.ecommerce.serviceImplementation;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.CurrentUserSession;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.CartDao;
import com.ecommerce.repository.CustomerDao;
import com.ecommerce.repository.UserSessionDao;
import com.ecommerce.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerD;
		
	@Autowired
	private UserSessionDao sessionD;
	
	@Autowired
	private CartDao cartD;
	
	
	@Override
	public Customer addCustomer(Customer cust) throws CustomerException {

		Customer existCustomer = customerD.findByEmail(cust.getEmail());
		
		if(existCustomer!=null) {
			throw new CustomerException("Customer already exists");
		}
		
		//saving the customer to database
		Customer new_cust = customerD.save(cust);
		//creating new cart object
		Cart obj = new Cart();
		obj.setCustomer(new_cust);
		//saving the cart
		Cart new_cart = cartD.save(obj);
		//linking the cart with customer
		new_cust.setCart(new_cart);
		
		return customerD.save(new_cust);
		
	}
	

	@Override
	public Customer updateCustomer(Customer cust, String key) throws CustomerException {
		
		CurrentUserSession loggedInUser = sessionD.findByUuid(key);
		
		if(loggedInUser == null)
			throw new CustomerException("Please enter valid key");
		
		
		if(cust.getCustomerId() == loggedInUser.getUserId()) {
			return customerD.save(cust);
		}
		else {
			throw new CustomerException("Invalid customer details, please login first!");
		}
		
	}
	

	@Override
	public Customer removeCustomer(Integer custId, String key) throws CustomerException {
		
		CurrentUserSession loggedInUser = sessionD.findByUuid(key);
		
		if(loggedInUser == null)
			throw new CustomerException("Please enter valid key");
		
		Optional<Customer> customerOpt = customerD.findById(custId);
		
		
		if(custId == loggedInUser.getUserId()) {
			
			customerD.delete(customerOpt.get());
			
			return customerOpt.get();
		}
		else {
			throw new CustomerException("Invalid customer details, please login first!");
		}
					
	}
	

	@Override
	public Customer viewCustomer(Integer custId) throws CustomerException {
		
		Optional<Customer> custOpt = customerD.findById(custId);
		
		if(custOpt.isPresent())
			return custOpt.get();
		
		else
			throw new CustomerException("Customer is not found with given customerId "+custId);
	}

	@Override
	public List<Customer> viewAllCustomer(String location) throws CustomerException {
		
		List<Customer> customers = customerD.viewAllCustomer(location);
		
		if(customers.isEmpty())
			throw new CustomerException("Customer is not found with given location: "+location);
		
		else {
			List<Customer> customerList = new ArrayList<>(customers);
			
			return customerList;
		}
	}

	
	
}