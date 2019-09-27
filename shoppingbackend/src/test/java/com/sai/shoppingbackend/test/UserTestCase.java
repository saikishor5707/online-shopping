package com.sai.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sai.shoppingbackend.dao.UserDAO;
import com.sai.shoppingbackend.dto.Address;
import com.sai.shoppingbackend.dto.Cart;
import com.sai.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;


	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sai.shoppingbackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}


/*
 * @Test public void testAddUser() {
 * 
 * user = new User() ; user.setFirstName("Hrithik"); user.setLastName("Roshan");
 * user.setEmail("hr@gmail.com"); user.setContactNumber("1234512345");
 * user.setRole("CUSTOMER"); //user.setEnabled(true); user.setPassword("12345");
 * 
 * // add the user assertEquals("Failed to add the user!", true,
 * userDAO.addUser(user));
 * 
 * address = new Address();
 * address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
 * address.setAddressLineTwo("Near Kaabil Store"); address.setCity("Mumbai");
 * address.setState("Maharashtra"); address.setCountry("India");
 * address.setPostalCode("400001"); address.setBilling(true);
 * 
 * // linked the address with the user address.setUserId(user.getId());
 * 
 * 
 * // add the address assertEquals("Failed to add the billing address!", true,
 * userDAO.addAddress(address));
 * 
 * 
 * if(user.getRole().equals("USER")) { cart = new Cart(); cart.setUser(user); //
 * add the cart //assertEquals("Failed to add the cart!", true,
 * userDAO.addCart(cart));
 * 
 * 
 * // add the shipping address address = new Address();
 * address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
 * address.setAddressLineTwo("Near Kudrat Store"); address.setCity("Mumbai");
 * address.setState("Maharashtra"); address.setCountry("India");
 * address.setPostalCode("400001"); //set the shipping to true
 * address.setShipping(true); //link it with the user
 * address.setUserId(user.getId()); //add the cart
 * assertEquals("Failed to add cart!", true, userDAO.addAddress(address));
 * 
 * 
 * } } }
 * 
 * 
 * 
 */









		// working for uni-directional
		
	/*
	 * @Test public void testAddAddress() { user = userDAO.get(1);
	 * 
	 * address = new Address();
	 * address.setAddressLineOne("301/B Jadoo Society, King Uncle Nagar");
	 * address.setAddressLineTwo("Near Store"); address.setCity("Mumbai");
	 * address.setState("Maharashtra"); address.setCountry("India");
	 * address.setPostalCode("400001");
	 * 
	 * address.setUser(user); // add the address
	 * assertEquals("Failed to add the address!", true,
	 * userDAO.addAddress(address)); }
	 * 
	 * @Test public void testUpdateCart() { user = userDAO.get(1); cart =
	 * user.getCart(); cart.setGrandTotal(10000); cart.setCartLines(1);
	 * assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart)); }
	 */

}	 



	
