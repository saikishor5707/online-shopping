package com.sai.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sai.shoppingbackend.dao.ProductDAO;
import com.sai.shoppingbackend.dto.Product;


@Repository("productDAO")
@Transactional
public  class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	/**
	 * single
	 */
	public Product get(int productId) {
		// TODO Auto-generated method stub
		try {
			//Add category list to DataBase
			return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return null;
	}
	
	/**
	 * List
	 */

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Product",Product.class).getResultList();
	}
	
	/**
	 * INSERT
	 */

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try {
			//Add category list to DataBase
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			//Add category list to DataBase
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		
		try {
			//Add category list to DataBase
			product.setActive(false);
			return this.update(product);
		
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		String selectActiveProducts = "FROM Product where active = :active";
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProducts,Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		String selectActiveProductsByCategory = "FROM Product where active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProductsByCategory,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return sessionFactory
				.getCurrentSession()
				.createQuery("from Product where active = :active order by id",Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
