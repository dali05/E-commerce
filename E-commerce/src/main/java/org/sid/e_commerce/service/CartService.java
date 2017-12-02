package org.sid.e_commerce.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sid.e_commerce.model.UserModel;
import org.sid.e_commercebackend.dao.CartLineDAO;
import org.sid.e_commercebackend.dao.ProduitDAO;
import org.sid.e_commercebackend.dao.UserDao;
import org.sid.e_commercebackend.beans.Cart;
import org.sid.e_commercebackend.beans.CartLine;
import org.sid.e_commercebackend.beans.Produit;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ProduitDAO productDAO;
		
	@Autowired
	private HttpSession session;

	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}

	
	public List<CartLine> getCartLines() {

		return cartLineDAO.list(getCart().getId());

	}
	
	/* to update the cart count */
	public String updateCartLine(int cartLineId, int count) {
		
		CartLine cartLine = cartLineDAO.get(cartLineId);		

		if(cartLine==null){
			return"result=error";
		}else{
			Produit product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			
			if(product.getQuantity()<=count){
				count=product.getQuantity();
			}
			
			// update the cart line
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			cartLineDAO.update(cartLine);

		
			// update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);

			return "result=updated";
		}
		
		

	}



	public String addCartLine(int productId) {		
		Cart cart = this.getCart();
		String response = null;
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		if(cartLine==null) {
			// add a new cartLine if a new product is getting added
			cartLine = new CartLine();
			Produit product = productDAO.get(productId);
			// transfer the product details to cartLine
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setProductCount(1);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice());
			
			// insert a new cartLine
			cartLineDAO.add(cartLine);
			
			// update the cart
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() + 1);
			cartLineDAO.updateCart(cart);

			response = "result=added";						
		} 
		else {
			// check if the cartLine has been already reached to maximum count
			if(cartLine.getProductCount() < 3) {
				// call the manageCartLine method to increase the count
				response = this.updateCartLine(cartLine.getId(), cartLine.getProductCount() + 1);				
			}			
			else {				
				response = "result=maximum";				
			}						
		}		
		return response;
	}
	

	public String deleteCartLine(int cartLineId) {
		
		//fetch the cartLine
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine==null){
			return "result=error";
		}else{
			//updete the cart
			Cart cart = this.getCart();	
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);		
			cartLineDAO.updateCart(cart);
			
			// remove the cartLine
			cartLineDAO.remove(cartLine);
					
			return "result=deleted";
		}
		
		
	}
}