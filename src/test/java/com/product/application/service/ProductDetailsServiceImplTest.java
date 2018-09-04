package com.product.application.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.product.application.dao.ProductDBDao;
import com.product.application.exception.ProductDetailsException;
import com.product.application.model.Product;
import com.product.application.model.ProductDetails;
import com.product.application.service.ProductDetailsServiceImpl;

/**
 * 
 * @author bharatoel
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductDetailsServiceImplTest {

	@InjectMocks
	ProductDetailsServiceImpl detailsServiceImpl;
	List<ProductDetails> details;

	@Mock
	ProductDetails det;

	@Mock
	ProductDBDao dbDao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void getProductDetailsTest() {
		details = new ArrayList<ProductDetails>();
		Product product = new Product();
		product.setProduct(details);
		Mockito.when(dbDao.getProductData()).thenReturn(details);
		try {
			Assert.assertEquals(detailsServiceImpl.getProductDetails().getProduct(), details);
		} catch (ProductDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void addProductDetails() {
		details = new ArrayList<ProductDetails>();
		Mockito.when(dbDao.getProductData()).thenReturn(details);
		Mockito.when(dbDao.createJson((Product) Mockito.anyObject())).thenReturn(true);

		try {
			Assert.assertEquals(detailsServiceImpl.addProductDetails(det), true);
		} catch (ProductDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void editProductDetails(){
		details = new ArrayList<ProductDetails>();
		Mockito.when(dbDao.getProductData()).thenReturn(null);
		
		try {
			Assert.assertEquals(detailsServiceImpl.editProductDetals(det).getProduct(),null);
		} catch (ProductDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
