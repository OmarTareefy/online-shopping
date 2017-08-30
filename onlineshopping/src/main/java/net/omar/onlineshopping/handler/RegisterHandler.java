package net.omar.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import net.omar.onlineshopping.model.RegisterModel;
import net.omar.shoppingbackend.dao.UserDAO;
import net.omar.shoppingbackend.dto.Address;
import net.omar.shoppingbackend.dto.Cart;
import net.omar.shoppingbackend.dto.User;

//this is to make it a bean
@Component
public class RegisterHandler {

	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	
	public RegisterModel init(){
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing){
		registerModel.setBilling(billing);
	}

	
	public String validateUser(User user, MessageContext error){
		String transitionValue= "success";
		
		
		
		if(!(user.getPassword().equals(user.getConfirmPassword()))){
			
			//checking if password matches confirm password
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password doesn't match the confirm password!")
					.build());
			
			transitionValue = "failure";
		}
		
		//check uniqueness of the email
		if(userDAO.getByEmail(user.getEmail()) != null){
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email address is already used")
					.build());
			
			transitionValue = "failure";
		}
	
		return transitionValue;
	}
	
	public String saveAll(RegisterModel registerModel){
		
		String transitionValue = "success";
		
		//fetch the user
		User user = registerModel.getUser();
		if(user.getRole().equals("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		//save the user
		userDAO.addUser(user);
		
		
		//get the address and save it
		Address billing = registerModel.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		userDAO.addAddress(billing);
		
		
		
		return transitionValue;
	}
}
