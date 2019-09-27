package com.sai.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sai.shoppingbackend.dao.CategoryDAO;
import com.sai.shoppingbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	


	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		String selectActiveCategory = "FROM Category WHERE active=:active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}
	
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		
		
	}

	@Override
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		try {
			//Add category list to DataBase
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			//Add category list to DataBase
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		category.setActive(false);
		try {
			//Add category list to DataBase
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
