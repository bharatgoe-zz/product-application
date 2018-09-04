package com.product.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.application.exception.ProductDetailsException;
import com.product.application.model.Product;
import com.product.application.model.ProductDetails;
import com.product.application.model.ResponseUser;
import com.product.application.service.ProductDetailsServiceImpl;

/**
 * 
 * @author bharatoel
 *
 * This is the controller class that maps the Apis to their respective methods.
 *
 */

@RestController
public class ItemController {

	@Autowired
	ProductDetailsServiceImpl detailsServiceImpl;


	/**
	 * This is the get product Api which returns the items details
	 * @returns the product list to the user
	 * @throws ProductDetailsException
	 */
	@RequestMapping(path = "/productdetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product getProductDetails() throws ProductDetailsException {
		return detailsServiceImpl.getProductDetails();
	}

	
	/**
	 * This is the add product Api which returns the items details
	 * @returns the addition of item if it is success or failure to the user
	 * @param Takes in the details of the item that needs to be added
	 * 
	 */
	@RequestMapping(path = "/addproduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseUser addProductDetails(@RequestBody ProductDetails details) {
		ResponseUser responseUser = new ResponseUser();
		try {
			boolean result=detailsServiceImpl.addProductDetails(details);
			responseUser.setAddItem(result);
		} catch (ProductDetailsException e) {
			System.out.println("Exceptions in addting Item" + e);
			responseUser.setAddItem(false);
		}
		return responseUser;
	}

	
	/**
	 * This is the edit product Api which edits the items details
	 * @returns the list of product with edited items
	 * @param Takes in the details of the item that needs to be edited
	 * 
	 */
	@RequestMapping(path = "/editproduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product editUserDetails(@RequestBody ProductDetails details) {
		try {
			return detailsServiceImpl.editProductDetals(details);
		} catch (ProductDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
