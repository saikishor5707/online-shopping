package com.sai.shoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	//private fields
	@Id
	@GeneratedValue(generator="product")
	@GenericGenerator(name="product",strategy="increment")
	private int id;
	private String code;
	
	@NotBlank(message = "Please enter the Product name!")
	private String name;
	
	@NotBlank(message = "Please enter the Brand name!")
	private String brand;
	
	@JsonIgnore
	@NotBlank(message = "Please enter the description for product!")
	private String description;
	
	@Column(name="unit_price")
	@Min(value=1)
	private double unitPrice;
	private int quantity;
	
	@Column(name="is_active")
	private boolean active;
	@JsonIgnore
	@Column(name="category_id")
	private int categoryId;
	@JsonIgnore
	@Column(name="supplier_id")
	private int supplierId;
	private int purchases;
	private int views;
	
	@Transient
	private MultipartFile file;
	
	//Default constuctor
	public Product() {
		this.code = "PRD"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	//setters and getters
	
	
	
	public int getId() {
		return id;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuanntity() {
		return quantity;
	}
	public void setQuanntity(int quanntity) {
		this.quantity = quanntity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	

}
