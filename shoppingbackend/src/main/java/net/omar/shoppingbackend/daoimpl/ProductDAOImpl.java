package net.omar.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.omar.shoppingbackend.dao.ProductDAO;
import net.omar.shoppingbackend.dto.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl  implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> list() {
		
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product", Product.class)
						.getResultList();
	}

	//single
	@Override
	public Product get(int productId) {
		return sessionFactory.getCurrentSession()
				.get(Product.class, Integer.valueOf(productId));
	}

	@Override
	public boolean add(Product product) {
		try{
			//Add product to the database table
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try{
			//update the product
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try{
			//make the product not active (delete)
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		Query query = sessionFactory.getCurrentSession()
						.createQuery(selectActiveProducts, Product.class);
		query.setParameter("active" ,true);
		
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		Query query = sessionFactory.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Product.class);
		query.setParameter("active", true);
		query.setParameter("categoryId" ,categoryId);
		
		return query.getResultList();
	}

	@Override
	public List<Product> getLatestAvtiveProducts(int count) {
		return sessionFactory.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
								.setMaxResults(count)
									.getResultList();
	}

}
