package com.sai.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sai.onlineshopping.util.FileUploadUtility;
import com.sai.onlineshopping.validator.ProductValidator;
import com.sai.shoppingbackend.dao.CategoryDAO;
import com.sai.shoppingbackend.dao.ProductDAO;
import com.sai.shoppingbackend.dto.Category;
import com.sai.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	//private static final Logger logger=LoggerFactory.getLogger(ManagementController.class); 
	
	@RequestMapping(value = "/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		
		//set few of the fields
		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product",nProduct);
		
		if(operation!=null) {
			if(operation.equals("product")) {
				mv.addObject("message","Product added successfully");
			}
		}
		
		return mv;
	}
	
	//handling product submission
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult results,Model model,HttpServletRequest request) {
		
		
		
		new ProductValidator().validate(mProduct,results);
		//check if there are any errors
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("message","Validation failed for Product submission");
			return "page";
		}
		
		//logger.info(mProduct.toString());
		//create a new product
		productDAO.add(mProduct);
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFie(request,mProduct.getFile(),mProduct.getCode());
		}
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostProductActivation(@PathVariable int id) {		
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!isActive);
		productDAO.update(product);		
		return (isActive)? "Product Dectivated Successfully!": "Product Activated Successfully";
	}
			
	//returning categories for all the request mappings
	@ModelAttribute("categories")
	public List<Category> getCategories() {
	return	categoryDAO.list();
	}

}
