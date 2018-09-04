package com.product.application.service;

import com.product.application.exception.ProductDetailsException;
import com.product.application.model.Product;
import com.product.application.model.ProductDetails;


/**
 * 
 * @author bharatoel
 *
 */

public interface ProductDetailsService {
	
	public Product getProductDetails() throws ProductDetailsException;
	
	public boolean addProductDetails(ProductDetails details) throws ProductDetailsException;
	
	public Product editProductDetals(ProductDetails details) throws ProductDetailsException;


}
