package net.omar.shoppingbackend.daoimpl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.omar.shoppingbackend.dao.UserDAO;
import net.omar.shoppingbackend.dto.Address;
import net.omar.shoppingbackend.dto.Cart;
import net.omar.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}	
	}

	@Override
	public User getByEmail(String email) {
		
		String selectQuery = "FROM User WHERE email = :email";
		try{
			return sessionFactory.getCurrentSession()
						.createQuery(selectQuery, User.class)
							.setParameter("email", email)
								.getSingleResult();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(int userId) {
		String selectQuery = "FROM Address WHERE userId = :user AND billing = :billing";
		
		try{
			Query query = sessionFactory.getCurrentSession()
							.createQuery(selectQuery, Address.class);
			query.setParameter("userId", userId);
			query.setParameter("billing", true);
			Address address = (Address)query.getSingleResult();
			return address;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(int userId) {
		String selectQuery = "FROM Address WHERE userId = :user AND shipping = :shipping";
		
		try{
			Query query = sessionFactory.getCurrentSession()
							.createQuery(selectQuery, Address.class);
			query.setParameter("userId", userId);
			query.setParameter("shipping", true);
			List <Address> addresses = query.getResultList();
			return addresses;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
}
