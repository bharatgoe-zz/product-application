package com.product.application.model;

import java.util.List;

/**
 * 
 * 
 * @author bharatoel
 * 
 * This class manages the list of items
 *
 */
public class Product {

	private List<ProductDetails> product;

	public List<ProductDetails> getProduct() {
		return product;
	}

	public void setProduct(List<ProductDetails> product) {
		this.product = product;
	}

}
