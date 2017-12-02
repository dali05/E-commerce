package org.sid.e_commerce.handler;

import java.io.Serializable;

import org.sid.e_commerce.model.RegisterModel;
import org.sid.e_commercebackend.beans.Address;
import org.sid.e_commercebackend.beans.Cart;
import org.sid.e_commercebackend.beans.User;
import org.sid.e_commercebackend.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Component;

@Component
public class RegisterHandler implements  Serializable {
	
	@Autowired
	private UserDao userDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;
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
		String transitionValue ="success";
	     if(!(user.getPassword().equals(user.getConfirmPassword()))){
	    	 error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password does not match the confirm password").build());
	    	 transitionValue="failure";
	     }
	     
	     if(userDAO.getByEmail(user.getEmail())!=null){
	    	 error.addMessage(new MessageBuilder().error().source("email").defaultText("Email adress is already used").build());
	    	 transitionValue="failure";
	     }
	     
		return transitionValue;
	}
	
	
	public String saveAll(RegisterModel model){
		String transitionValue="success";
		//fetch the user
		User user = model.getUser();
		if(user.getRole().equals("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		//encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//save the user
		userDAO.addUser(user);
		//get the address
		Address billing = model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		//save the address
		userDAO.addAddress(billing);
		return transitionValue;
	}
}
