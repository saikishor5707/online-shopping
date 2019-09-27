package com.sai.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sai.onlineshopping.exception.ProductNotFoundException;
import com.sai.shoppingbackend.dao.CategoryDAO;
import com.sai.shoppingbackend.dao.ProductDAO;
import com.sai.shoppingbackend.dto.Category;
import com.sai.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		
	ModelAndView mv = new ModelAndView("page");	
	
	mv.addObject("title", "Home");
	//passing list of categories
	mv.addObject("categories",categoryDAO.list());
	mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about() {
		
	ModelAndView mv = new ModelAndView("page");	
	mv.addObject("title", "About Us");
	mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact() {
		
	ModelAndView mv = new ModelAndView("page");	
	mv.addObject("title", "Contact");
	mv.addObject("userClickContact", true);
		return mv;
	}
	
	/**
	 * Method to load all products based on category
	 */
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		
	ModelAndView mv = new ModelAndView("page");	
	
	mv.addObject("title", "All Products");
	//passing list of categories
	mv.addObject("categories",categoryDAO.list());
	mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id) {
		
		Category category =null;
		category = categoryDAO.get(id);
		
		
	ModelAndView mv = new ModelAndView("page");	
	
	mv.addObject("title", category.getName());
	//passing list of categories
	mv.addObject("categories",categoryDAO.list());
	
	//passing single category object
		mv.addObject("category",category);
		
	mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	/**
	 * Viewing Single Product
	 * 
	 */
	
	@RequestMapping(value="show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id)throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView();
		Product product = productDAO.get(id);
		
		if(product == null)throw new ProductNotFoundException();
		product.setViews(product.getViews());
		
		/**
		 * updating the view count
		 */
		productDAO.update(product);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error,
			@RequestParam(name="logout", required = false) String logout) {
		ModelAndView mv= new ModelAndView("login");
		mv.addObject("title", "Login");
		if(error!=null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		if(logout!=null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;
	}
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("errorTitle", "Aha! Caught You.");		
		mv.addObject("errorDescription", "You are not authorized to view this page!");		
		mv.addObject("title", "403 Access Denied");		
		return mv;
	}	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// Invalidates HTTP Session, then unbinds any objects bound to it.
	    // Removes the authentication from securitycontext 		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		
		return "redirect:/login?logout";
	}	
	

}
