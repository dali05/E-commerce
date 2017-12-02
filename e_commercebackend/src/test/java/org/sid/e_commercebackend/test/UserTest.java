package org.sid.e_commercebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.sid.e_commercebackend.beans.Address;
import org.sid.e_commercebackend.beans.Cart;
import org.sid.e_commercebackend.beans.User;
import org.sid.e_commercebackend.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {

	private static AnnotationConfigApplicationContext context;
	private static UserDao userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.sid.e_commercebackend");
		context.refresh();

		userDAO = (UserDao) context.getBean("userDAO");
	}

//	 @Test
//	 public void testAddUser() {
//	
//	 user = new User();
//	 user.setFirstName("dali");
//	 user.setLastName("laaroussi");
//	 user.setEmail("dali@gmail.com");
//	 user.setContactNumber("1234512345");
//	 user.setRole("USER");
//	 user.setEnabled(true);
//	 user.setPassword("12345");
//	
//	 // add the user
//	 assertEquals("Failed to add the user!", true, userDAO.addUser(user));
//	
//	 address = new Address();
//	 address.setAddressLineOne("ben arous, rades");
//	 address.setAddressLineTwo("ben arous");
//	 address.setCity("rades");
//	 address.setState("ben arous");
//	 address.setCountry("Tunisia");
//	 address.setPostalCode("2020");
//	 address.setBilling(true);
//	
//	 // link the user with the address using user id
//	 address.setUserId(user.getId());
//	 // add the address
//	 assertEquals("Failed to add the billing address!", true,
//	 userDAO.addAddress(address));
//	
//	 if (user.getRole().equals("USER")) {
//	 // create a cart for this user
//	 cart = new Cart();
//	 cart.setUser(user);
//	 // add the cart
//	 assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
//	
//	 // add a shipping address for this user
//	 address = new Address();
//	 address.setAddressLineOne("ben arous, rades");
//	 address.setAddressLineTwo("ben arous");
//	 address.setCity("rades");
//	 address.setState("ben arous");
//	 address.setCountry("tunisia");
//	 address.setPostalCode("2020");
//	 // set shipping to true
//	 address.setShipping(true);
//	
//	 // link it with the user
//	 address.setUserId(user.getId());
//	
//	 // add the shipping address
//	 assertEquals("Failed to add shipping address", true,
//	 userDAO.addAddress(address));
//	
//	 }
//	
//	 }

	/*---------------------------------------*/

//	 @Test
//	 public void testAddUser() {
//	
//	 user = new User();
//	 user.setFirstName("dali");
//	 user.setLastName("laaroussi");
//	 user.setEmail("dali@gmail.com");
//	 user.setContactNumber("1234512345");
//	 user.setRole("USER");
//	 user.setEnabled(true);
//	 user.setPassword("12345");
//	
//	 if (user.getRole().equals("USER")) {
//	 // create a cart for this user
//	 cart = new Cart();
//	 cart.setUser(user);
//	
//     //attach cart with user
//	 user.setCart(cart);
//	
//	}
//	// // add the user
//	 assertEquals("Failed to add the user!", true, userDAO.addUser(user));
//
//	 }

//	 @Test
//	 public void testUpdateCart() {
//	 //fetch the user by its email
//	 user = userDAO.getByEmail("dali@gmail.com");
//	 //get the cart of the user
//	 cart = user.getCart();
//	
//	 cart.setGrandTotal(5555);
//	 cart.setCartLines(2);
//	 assertEquals("failed to update the cart !",
//	 true,userDAO.updateCart(cart));
//	 }

//	 @Test
//	 public void testUpdateCart() {
//	 // add an user
//	
//	 user = new User();
//	 user.setFirstName("dali");
//	 user.setLastName("laaroussi");
//	 user.setEmail("dali@gmail.com");
//	 user.setContactNumber("1234512345");
//	 user.setRole("USER");
//	 user.setEnabled(true);
//	 user.setPassword("12345");
//	 // add the user
//	 assertEquals("Failed to add the user!", true, userDAO.addUser(user));
//	
//	 // add the address
//	 address = new Address();
//	 address.setAddressLineOne("ben arous, rades");
//	 address.setAddressLineTwo("ben arous");
//	 address.setCity("rades");
//	 address.setState("ben arous");
//	 address.setCountry("Tunisia");
//	 address.setPostalCode("2020");
//	 address.setBilling(true);
//	
//	 // attached the user to the adress
//	 address.setUser(user);
//	 assertEquals("Failed to add address!", true,
//	 userDAO.addAddress(address));
//	
//	 // add the shipping
//	 address = new Address();
//	 address.setAddressLineOne("ben arous, rades");
//	 address.setAddressLineTwo("ben arous");
//	 address.setCity("rades");
//	 address.setState("ben arous");
//	 address.setCountry("tunisia");
//	 address.setPostalCode("2020");
//	 // set shipping to true
//	 address.setShipping(true);
//	
//	 // attached the user to the adress
//	 address.setUser(user);
//	 assertEquals("Failed to add shipping address!", true,
//	 userDAO.addAddress(address));
//	 }

//	@Test
//	public void testAddress() {
//		user=userDAO.getByEmail("dali@gmail.com");
//	    //add the shipping address
//		address = new Address();
//		address.setAddressLineOne("ben arous, zahra");
//		address.setAddressLineTwo("ben arous");
//		address.setCity("zahra");
//		address.setState("ben arous");
//		address.setCountry("tunisia");
//		address.setPostalCode("2040");
//		// set shipping to true
//		address.setShipping(true);
//
//		// attached the user to the adress
//		address.setUser(user);
//		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//	}

//	@Test
//	public void testGetAddress(){
//		user = userDAO.getByEmail("dali@gmail.com");
//		
//		assertEquals("Failed to fetch the list of address and size does not much!", 2, 
//				userDAO.listShippingAddresses(user).size());
//		assertEquals("Failed to fetch the billing address and size does not much!", "rades", 
//				userDAO.getBillingAddress(user).getCity());
//	}
	
}
