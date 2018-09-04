package com.product.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.application.dao.ProductDBDao;
import com.product.application.exception.ProductDetailsException;
import com.product.application.model.Product;
import com.product.application.model.ProductDetails;

/**
 * 
 * @author bharatoel
 *
 *this class processed the item details and sends them to dao for reading/wring
 *
 */

@Component
public class ProductDetailsServiceImpl implements ProductDetailsService {

	@Autowired
	ProductDBDao dbDao;

	Product product;

	
	/**
	 * 
	 * This method fetches the item details from the back end db/file
	 * 
	 */
	public Product getProductDetails() throws ProductDetailsException {
		List<ProductDetails> details = dbDao.getProductData();
		Product product = new Product();
		product.setProduct(details);
		return product;
	}

	
	/**
	 * 
	 * This method is used to add item to the back end 
	 * 
	 *  @param takes in the item details as input and returns the success/failure of additon of item
	 * 
	 */
	public boolean addProductDetails(ProductDetails details) throws ProductDetailsException {

		List<ProductDetails> productDetails = dbDao.getProductData();
		if (productDetails == null) {
			productDetails = new ArrayList<ProductDetails>();
		}
		int count = productDetails.size() + 1;
		details.setId(count);
		productDetails.add(details);
		product = new Product();
		product.setProduct(productDetails);
		boolean result=dbDao.createJson(product);
		return result;

	}
	
	/**
	 * 
	 * This method is used to edit the item details.
	 * 
	 * @param takes in the details of the item that needs to be updated
	 * 
	 * 
	 */

	public Product editProductDetals(ProductDetails details) throws ProductDetailsException {
		List<ProductDetails> detailsEdit = dbDao.getProductData();
		if (detailsEdit == null) {
			product = new Product();
			product.setProduct(detailsEdit);
			return product;
		}
		for (ProductDetails details2 : detailsEdit) {
			if (details2.getId() == details.getId()) {
				details2.setId(details.getId());
				details2.setName(details.getName());
				details2.setDescription(details.getDescription());
				details2.setPrice(details.getPrice());
			}
		}
		product = new Product();
		product.setProduct(detailsEdit);
		dbDao.createJson(product);
		return product;
	}

}
