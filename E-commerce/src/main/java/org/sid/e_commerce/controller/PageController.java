package org.sid.e_commerce.controller;

import org.sid.e_commerce.exception.ProductNotFoundExeption;
import org.sid.e_commercebackend.beans.Categorie;
import org.sid.e_commercebackend.beans.Produit;
import org.sid.e_commercebackend.dao.CategorieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.sid.e_commercebackend.dao.ProduitDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class PageController {
    private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategorieDAO categorieDAO;
	@Autowired
	private ProduitDAO ProduitDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageControoler index method info");
		logger.debug("Inside PageControoler index method debug");
		// passing the list of categories
		mv.addObject("categories", categorieDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/*
	 * methods to load all the products and based on category
	 */
	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", categorieDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = {"/show/categorie/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categorieDAO to fetch a single categorie
		Categorie categorie = null;
		categorie = categorieDAO.get(id);

		mv.addObject("title", categorie.getName());

		// passing the list of categories
		mv.addObject("categories", categorieDAO.list());
		
		//passing the single categorie object
		mv.addObject("categorie", categorie);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
/*
 * 	Viewing a single product
 */
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundExeption{
		ModelAndView mv = new ModelAndView("page");
		
			Produit produit = ProduitDAO.get(id);
			if(produit==null) throw new ProductNotFoundExeption();
		//update the view count
		produit.setViews(produit.getViews()+1);
		ProduitDAO.update(produit);
		
		mv.addObject("title",produit.getName());
		mv.addObject("produit",produit);
		
		mv.addObject("userClickShowProduct",true);
		
		return mv;
	}
	
}
