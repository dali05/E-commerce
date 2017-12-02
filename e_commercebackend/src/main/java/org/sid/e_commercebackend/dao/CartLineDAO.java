package org.sid.e_commercebackend.dao;

import java.util.List;

import org.sid.e_commercebackend.beans.Cart;
import org.sid.e_commercebackend.beans.CartLine;


public interface CartLineDAO {

	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	// list of available cartLine
    public List<CartLine> listAvailable(int cartId);
	
	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId);		
		
	 //updating the cart
	 boolean updateCart(Cart cart);
	
	
	
	// adding order details
	//boolean addOrderDetail(OrderDetail orderDetail);

	
}

