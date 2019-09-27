package com.sai.onlineshopping.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{
	
	private String message;
	
	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException() {
		this("product is not available!");
	}
	
	public ProductNotFoundException(String message) {
		this.message = System.currentTimeMillis()+" "+message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
