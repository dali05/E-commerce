package org.sid.e_commercebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.sid.e_commercebackend.dao.CartLineDAO;
import org.sid.e_commercebackend.dao.ProduitDAO;
import org.sid.e_commercebackend.dao.UserDao;
import org.sid.e_commercebackend.beans.Cart;
import org.sid.e_commercebackend.beans.CartLine;
import org.sid.e_commercebackend.beans.Produit;
import org.sid.e_commercebackend.beans.User;

public class CartLineTestCase {

	

	private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO;
	private static ProduitDAO productDAO;
	private static UserDao userDAO;
	
	
	private Produit product = null;
	private User user=null;
	private Cart cart= null;
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.sid.e_commercebackend");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		productDAO = (ProduitDAO)context.getBean("produitDAO");
		userDAO = (UserDao)context.getBean("userDAO");
	}
	
	
	@Test
	public void testAddCartLine() {
		
		// get the user
		user = userDAO.getByEmail("user@user.com");		
		// fetch the cart
		cart = user.getCart();
		
		// fetch the product 
		product = productDAO.get(1);
		
		// Create a new CartLine
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount()*product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());	
        cartLine.setProduct(product);
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
        //update the cart
		
		cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		assertEquals("Failed to update the Cart!",true, cartLineDAO.updateCart(cart));

	}
	
	
	
//	@Test
//	public void testUpdateCartLine() {
//
//		// fetch the user and then cart of that user
//		User user = userDAO.getByEmail("absr@gmail.com");		
//		Cart cart = user.getCart();
//				
//		cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), 2);
//		
//		cartLine.setProductCount(cartLine.getProductCount() + 1);
//				
//		double oldTotal = cartLine.getTotal();
//				
//		cartLine.setTotal(cartLine.getProduct().getUnitPrice() * cartLine.getProductCount());
//		
//		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
//		
//		assertEquals("Failed to update the CartLine!",true, cartLineDAO.update(cartLine));	
//
//		
//	}
//	
	
	
}
