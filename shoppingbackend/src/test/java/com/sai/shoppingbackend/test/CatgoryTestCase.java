package com.sai.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sai.shoppingbackend.dao.CategoryDAO;
import com.sai.shoppingbackend.dto.Category;

public class CatgoryTestCase {
	
    private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sai.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.get(2);
	 * assertEquals("successfully fetched a single category from the table!"
	 * ,"Mobile",category.getName());
	 * 
	 * }
	 */
	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(1);
	 * category.setName("TV");
	 * assertEquals("successfully updated  category in the table!",true,categoryDAO.
	 * update(category));
	 * 
	 * }
	 */
	
	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(1);
	 * 
	 * assertEquals("successfully Deleted  category in the table!",true,categoryDAO.
	 * delete(category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testListCategory() {
	 * 
	 * 
	 * assertEquals("successfully Fetched  list of categories from the table!",2,
	 * categoryDAO.list().size());
	 * 
	 * }
	 */
	
	
	/*
	 * @Test public void testAddCategory() { category = new Category();
	 * //category.setId(4); category.setName("Television");
	 * category.setDescription("This is some description about Television!");
	 * category.setImageURL("CAT3.png"); category.setActive(false);
	 * 
	 * assertEquals("successfully added a category inside the table!",true,
	 * categoryDAO.add(category)); }
	 */
	 
	@Test
	public void testCRUDCategory() {
		//Add a Category
		category = new Category();
		  //category.setId(4);
		 category.setName("Television");
		 category.setDescription("This is some description about Television!");
		 category.setImageURL("CAT1.png"); category.setActive(true);
		  
		  assertEquals("successfully added a category inside the table!",true,
		  categoryDAO.add(category)); 
		  
		  category = new Category();
		  //category.setId(4);
		 category.setName("Laptop");
		 category.setDescription("This is some description about Laptop!");
		 category.setImageURL("CAT2.png"); category.setActive(true);
		  
		  assertEquals("successfully added a category inside the table!",true,
		  categoryDAO.add(category)); 
	
		  //fetching and updating a category
		  
			   category = categoryDAO.get(1);
			  category.setName("TV");
			  assertEquals("successfully updated  category in the table!",true,categoryDAO.
			  update(category));
			  
		//Deleting the Category
			  
		assertEquals("successfully Deleted  category in the table!",true,categoryDAO.
						  delete(category));
		
		//fetching the list
		
		assertEquals("successfully Fetched  list of categories from the table!",1,
				  categoryDAO.list().size());	  
			  }
	
}
