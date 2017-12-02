package org.sid.e_commercebackend.dao;

import java.util.List;

import org.sid.e_commercebackend.beans.Address;
import org.sid.e_commercebackend.beans.Cart;
import org.sid.e_commercebackend.beans.User;

public interface UserDao {

	//add an user
	boolean addUser(User user);
	User getByEmail(String email);
	//add an address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	
}
