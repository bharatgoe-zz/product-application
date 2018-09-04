package com.product.application.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.product.application.model.Product;
import com.product.application.model.ProductDetails;;

/**
 * 
 * @author bharatoel
 * 
 * This is the dao impl class that manages the back end data for this project
 *
 */

@Component
public class ProductDBDaoImpl implements ProductDBDao {

	FileWriter writer = null;
	
	/**
	 * 
	 * This method is used to write details of an item to the back end db in this case Json
	 * 
	 * 
	 * @param This takes in product details as input
	 */
	public boolean createJson(Product details) {
		ObjectMapper mapperObj;
		mapperObj = new ObjectMapper();

		File file = new File("C:\\Users\\Shubhra\\Desktop\\itemproductdetails.json");
		try {
			if (file.createNewFile()) {
				System.out.println("file created!!!");
			} else {
				System.out.println("file exists!!!");
			}
			writer = new FileWriter(file);
			writer.write(mapperObj.writeValueAsString(details));
			writer.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	
	/**
	 * 
	 * This function is used to consume data from the back end db
	 * 
	 */
	public List<ProductDetails> getProductData() {

		JSONParser jsonParser = new JSONParser();
		try {
			File file = new File("/tmp/itemproductdetails.json");
			if (!file.exists()) {
				return null;
			}
			Object object = jsonParser.parse(new FileReader("/tmp/itemproductdetails.json"));
			JSONObject jsonObject = (JSONObject) object;
			JSONArray product = (JSONArray) jsonObject.get("product");
			return createProductList(product);
		} catch (Exception e) {
			System.out.println("exception");
		}
		return null;
	}

	
	
	/**
	 * @param product
	 * @return
	 */
	private List<ProductDetails> createProductList(JSONArray product) {
		ObjectMapper mapper = new ObjectMapper();
		List<ProductDetails> list = null;
		try {
			list = mapper.readValue(product.toJSONString(),
					TypeFactory.defaultInstance().constructCollectionType(List.class, ProductDetails.class));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	/*
	 * public static void main(String args[]) { ProductDBDaoImpl daoImpl = new
	 * ProductDBDaoImpl();
	 * 
	 * ProductDetails details1 = new ProductDetails(); details1.setId(1);
	 * details1.setName("bharat"); details1.setPrice("10");
	 * details1.setDescription("Product1");
	 * 
	 * ProductDetails details2 = new ProductDetails(); details2.setId(2);
	 * details2.setName("shubhra"); details2.setPrice("20");
	 * details2.setDescription("Product2");
	 * 
	 * Product product = new Product(); List<ProductDetails> list = new
	 * ArrayList<ProductDetails>(); list.add(details1); list.add(details2);
	 * product.setProduct(list);
	 * 
	 * daoImpl.createJson(product); // daoImpl.getProductData();
	 */
}
