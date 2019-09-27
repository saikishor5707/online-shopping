package com.sai.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sai.shoppingbackend.dao.ProductDAO;
import com.sai.shoppingbackend.dto.Category;
import com.sai.shoppingbackend.dto.Product;



public class ProductTestCase {
	
	 private static AnnotationConfigApplicationContext context;
		private static ProductDAO productDAO;
		private Product product;
		
		@BeforeClass
		public static void init() {
			
			context = new AnnotationConfigApplicationContext();
			context.scan("com.sai.shoppingbackend");
			context.refresh();
			productDAO = (ProductDAO)context.getBean("productDAO");
			
		}
		
		@Test
		public void testCRUDProduct() {
		
		  //Add a Category
			product = new Product(); 
			//category.setId(4);
		  product.setName("Oppo selfie s53"); product.setBrand("Oppo");
		  product.setDescription("This is some description about Oppo mobile phones!");
		  product.setUnitPrice(25000); product.setActive(true);
		  product.setCategoryId(3); product.setSupplierId(3);
		  
		  assertEquals("something went wrong while inserting a new product!",true,
		  productDAO.add(product));
		 
			  
		
		  //fetching and updating a category
		  
		
		  product = productDAO.get(8); product.setName("Samsung Galaxy s7");
		  assertEquals("something went wrong while reading and updating record!",true,
		  productDAO.update(product));
		 
		  
		  
		
		  //Deleting the Category
		  
		  assertEquals("something went wrong while deleting record!",true,productDAO.
		  delete(product));
		  
		  //fetching the list
		  
		  assertEquals("something went wrong while fetching the list!",6,
		  productDAO.list().size());
		 
		 	
			  
			  
			
		
			  
				  
			  
				  }


}
