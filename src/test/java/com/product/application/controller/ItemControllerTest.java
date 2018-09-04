package com.product.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.google.gson.Gson;
import com.product.application.controller.ItemController;
import com.product.application.exception.ProductDetailsException;
import com.product.application.model.Product;
import com.product.application.model.ProductDetails;
import com.product.application.model.ResponseUser;
import com.product.application.service.ProductDetailsServiceImpl;

import junit.framework.Assert;

/**
 * 
 * @author bharatgoel
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@InjectMocks
	ItemController controller;

	@Mock
	ProductDetailsServiceImpl detailsServiceImpl;

	MockHttpServletRequest requestMock = null;
	MockHttpServletResponse responseMock = null;
	Jackson2JsonObjectMapper mapper;
	RequestMappingHandlerAdapter handlerAdapter;
	Gson gson = null;

	@Before
	public void setup() {
		requestMock = new MockHttpServletRequest();
		requestMock.setContentType(MediaType.APPLICATION_JSON_VALUE);
		requestMock.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, Boolean.FALSE);
		responseMock = new MockHttpServletResponse();
		handlerAdapter = new RequestMappingHandlerAdapter();
		mapper = new Jackson2JsonObjectMapper();
		GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
		gson = new Gson();
		converter.setGson(gson);
		HttpMessageConverter[] messageConverters = { new GsonHttpMessageConverter() };

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetProductDetails() {
		requestMock.setRequestURI("/productdetails");
		requestMock.setMethod("GET");
		requestMock.setContent(null);
		Product product = new Product();
		try {
			Mockito.when(detailsServiceImpl.getProductDetails()).thenReturn(product);

			Assert.assertEquals(controller.getProductDetails(), product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testAddProductDetails() {
		ProductDetails details = new ProductDetails();
		try {
			Mockito.when(detailsServiceImpl.addProductDetails(details)).thenReturn(true);
			ResponseUser user = controller.addProductDetails(details);
			Assert.assertEquals(user.isAddItem(), true);

		} catch (ProductDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testEditProductDetails(){
		ProductDetails details = new ProductDetails();
		Product product= new Product();
		List<ProductDetails> detailList= new ArrayList<ProductDetails>();
		detailList.add(details);
		product.setProduct(detailList);
		try {
			Mockito.when(detailsServiceImpl.editProductDetals(details)).thenReturn(product);
			Assert.assertEquals(controller.editUserDetails(details), product);
		} catch (ProductDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
