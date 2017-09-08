package net.omar.onlineshopping.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.omar.onlineshopping.model.UserModel;
import net.omar.shoppingbackend.dao.UserDAO;
import net.omar.shoppingbackend.dto.User;

//this is how we create a global controller
@ControllerAdvice
public class GlobalController {
	
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel(){
		
		if(session.getAttribute("userModel") == null){
			
			//add the user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDAO.getByEmail(authentication.getName());
			if (user != null){
				
				// create a new user model to pass the user details
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				
				if(userModel.getRole().equals("USER")){
					//set the cart only if the user is a buyer
					userModel.setCart(user.getCart());
				}
				
				session.setAttribute("userModel", userModel);
				//return userModel;
			}		
		}
		
		return (UserModel) session.getAttribute("userModel");
		
		
	}
	
	/*
	@ModelAttribute("language")
	public String getLanguage(){
		Locale locale = LocaleContextHolder.getLocale();

		
		return locale.getDisplayName();
		
	}
	*/
}
