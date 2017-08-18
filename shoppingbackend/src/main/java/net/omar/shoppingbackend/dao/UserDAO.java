package net.omar.shoppingbackend.dao;

import java.util.List;

import net.omar.shoppingbackend.dto.Address;
import net.omar.shoppingbackend.dto.Cart;
import net.omar.shoppingbackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	/*
	Address getBillingAddress(int user_id);
	List<Address> listShippingAddresses(int user_id);
	*/
	boolean updateCart(Cart cart);
}
