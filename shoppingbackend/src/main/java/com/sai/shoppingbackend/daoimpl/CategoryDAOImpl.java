package com.sai.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sai.shoppingbackend.dao.CategoryDAO;
import com.sai.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Televison");
		category.setDescription("This is some description about Televison!");
		category.setImageURL("CAT1.png");
		categories.add(category);

		// Adding second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description about Mobile!");
		category.setImageURL("CAT2.png");
		categories.add(category);

		// Adding third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description about Laptop!");
		category.setImageURL("CAT3.png");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	
	Category get(int id) {
		
		for(Category category:categories) {
			if(category.getId() == id) return category;
		}
		
		return null;
	}

}
