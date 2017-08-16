package net.omar.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import net.omar.shoppingbackend.dao.UserDAO;
import net.omar.shoppingbackend.dto.Address;
import net.omar.shoppingbackend.dto.Cart;
import net.omar.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.omar.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	/*@Test
	public void testAdd(){
		
		//adding a user
		user = new User();
		user.setFirstName("Omar");
		user.setLastName("Khalil");
		user.setEmail("omar.tareefy@gmail.com");
		user.setContactNumber("0786501066");
		user.setRole("USER");
		user.setPassword("123");
		
		assertEquals("Error in adding a user inside the table!", true, userDAO.addUser(user));
		
		
		//adding an address
		address = new Address();
		address.setAddressLineOne("Amman");
		address.setAddressLineTwo("TV and Radio street");
		address.setCity("Amman");
		address.setState("Amman");
		address.setCountry("Jordan");
		address.setPostalCode("12355");
		address.setBilling(true);
		
		//Linking the address with the user using the user id
		address.setUserId(user.getId());
		
		assertEquals("Error in adding a billing address inside the table!", true, userDAO.addAddress(address));
		
		
		if(user.getRole().equals("USER")){
			//creating a cart for this user
			cart = new Cart();
			cart.setUser(user);
			assertEquals("Error in adding a cart inside the table!", true, userDAO.addCart(cart));
			
			
			//aadding a shipping address for this user
			address = new Address();
			address.setAddressLineOne("Amman");
			address.setAddressLineTwo("TV and Radio street");
			address.setCity("Amman");
			address.setState("Amman");
			address.setCountry("Jordan");
			address.setPostalCode("12355");
			address.setShipping(true);
			//link it with the user
			address.setUserId(user.getId());
			assertEquals("Error in shipping address inside the table!", true, userDAO.addAddress(address));
			
		}
	}*/
	
	/*
	@Test
	public void testAdd(){
		user = new User();
		user.setFirstName("Omar");
		user.setLastName("Khalil");
		user.setEmail("omar.tareefy@gmail.com");
		user.setContactNumber("0786501066");
		user.setRole("USER");
		user.setPassword("123");
		
		if(user.getRole().equals("USER")){
			//creating a cart for this user
			cart = new Cart();
			
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//add the user
		assertEquals("Error in adding a user inside the table!", true, userDAO.addUser(user));
	}*/
	
	
	@Test
	public void testUpdateCart(){
		
		//fetching a user
		user = userDAO.getByEmail("omar.tareefy@gmail.com");
		
		//getting the cart of that user
		
		cart = user.getCart();
		cart.setGrandTotal(5555);
		cart.setCartLines(2);
		
		assertEquals("Error in updating the cart!", true, userDAO.updateCart(cart));
	}


}
