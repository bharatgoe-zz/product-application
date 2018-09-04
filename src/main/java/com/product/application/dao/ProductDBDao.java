package com.product.application.dao;

import java.util.List;

import com.product.application.model.Product;
import com.product.application.model.ProductDetails;


/**
 * 
 * @author bharatoel
 *
 */
public interface ProductDBDao {
	
	public boolean createJson(Product details);
	
	public List<ProductDetails> getProductData();

}
