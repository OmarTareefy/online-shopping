package net.omar.onlineshopping.handler;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import net.omar.onlineshopping.model.RegisterModel;
import net.omar.shoppingbackend.dto.Address;
import net.omar.shoppingbackend.dto.User;

//this is to make it a bean
@Component
public class RegisterHandler implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterModel init(){
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing){
		registerModel.setBilling(billing);
	}

}
