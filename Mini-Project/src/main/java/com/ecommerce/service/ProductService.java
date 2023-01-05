package com.ecommerce.service;


import java.util.List;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;




public interface ProductService {
	
	
	public List<Product> viewAllProductsService() throws ProductException;

	public Product viewProductByIdSerivce(Integer id) throws ProductException;

	public Product addProductService(Product product,String key) throws ProductException, LoginException, CustomerException;

	public Product updateProductService(Product product,String key) throws ProductException, CustomerException;

	public List<Product> viewProductByCategoryService(String c_name) throws ProductException;

	public Product removeProductService(Integer id,String key) throws ProductException, CustomerException;
	
	
	

}

