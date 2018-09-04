package com.product.application.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.product.application.dao.ProductDBDaoImpl;
import com.product.application.model.Product;
import com.product.application.model.ProductDetails;

/**
 * 
 * @author bharatgoel
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductDBDaoImplTest {

	ProductDBDaoImpl dbDao;
	ProductDetails details;
	Product product;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		details = new ProductDetails();
		details.setId(1);
		details.setName("test");
		details.setPrice("20");
		details.setDescription("Test description");
		List<ProductDetails> pDetails = new ArrayList<ProductDetails>();
		pDetails.add(details);
		product = new Product();
		product.setProduct(pDetails);
	}

	@Test
	public void testCreateJson() {

		ProductDBDaoImpl dbDao = new ProductDBDaoImpl();
		dbDao.createJson(product);
		File file = new File("/tmp/itemproductdetails.json");
		Assert.assertEquals(file.exists(), true);
		file.delete();
	}
	
	@Test
	public void testGetProductData(){
		ProductDBDaoImpl dbDao = new ProductDBDaoImpl();
		dbDao.createJson(product);
		File file = new File("/tmp/itemproductdetails.json");
		try {
			dbDao.createJson(product);
			Assert.assertEquals(dbDao.getProductData().get(0).getName(),"test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file.delete();
	}
	
	

}
