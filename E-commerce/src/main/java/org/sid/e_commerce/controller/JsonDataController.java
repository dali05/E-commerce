package org.sid.e_commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.sid.e_commercebackend.beans.Produit;
import org.sid.e_commercebackend.dao.ProduitDAO;


@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProduitDAO productDAO;
	

	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Produit> getAllProductsList() {		
		return productDAO.list();
				
	}	
	
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Produit> getAllProducts() {
		
		return productDAO.listActiveProducts();
				
	}
	
	@RequestMapping("/categorie/{id}/product")
	@ResponseBody
	public List<Produit> getProductsByCategory(@PathVariable int id) {
		
		return productDAO.listActiveProductsByCategory(id);
				
	}
	
	
	@RequestMapping("/mv/products")
	@ResponseBody
	public List<Produit> getMostViewedProducts() {		
		return productDAO.getProductsByParam("views", 5);				
	}
		
	@RequestMapping("/mp/products")
	@ResponseBody
	public List<Produit> getMostPurchasedProducts() {		
		return productDAO.getProductsByParam("purchases", 5);				
	}
}
