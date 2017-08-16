package net.omar.shoppingbackend.dao;

import net.omar.shoppingbackend.dto.Address;
import net.omar.shoppingbackend.dto.Cart;
import net.omar.shoppingbackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	boolean updateCart(Cart cart);
}
