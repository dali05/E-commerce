package org.sid.e_commerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.sid.e_commerce.util.FileUploadUtility;
import org.sid.e_commerce.validator.ProduitValidator;
import org.sid.e_commercebackend.beans.Categorie;
import org.sid.e_commercebackend.beans.Produit;
import org.sid.e_commercebackend.dao.CategorieDAO;
import org.sid.e_commercebackend.dao.ProduitDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CategorieDAO categorieDAO;
	@Autowired
	private ProduitDAO produitDAO;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showAdminProducts(@RequestParam(name="operation", required=false) String operation){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		Produit p = new Produit();
		
		p.setSupplierId(1);
		p.setActive(true);
		mv.addObject("products",p);
		
		if(operation!=null){
			if(operation.equals("product")){
				mv.addObject("message","product Submitted Successfully");
			}else if(operation.equals("category")){
				mv.addObject("message","category Submitted Successfully");

			}
			
		}		
		return mv;
	}
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView updateAdminProducts(@PathVariable int id){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		//fetch the product from the database
		
		Produit p = produitDAO.get(id);
		//set the product fetch from database
		mv.addObject("products",p);
		
		return mv;
	}
	//handling product submission
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid  @ModelAttribute("products")
	Produit produit,BindingResult bindingResult,Model model,HttpServletRequest request) {
		if(produit.getId()==0){
		   new ProduitValidator().validate(produit, bindingResult);
		}else{
			if(!produit.getFile().getOriginalFilename().equals("")){
				new ProduitValidator().validate(produit, bindingResult);
			}
		}
		
		//check if there any errors
		if(bindingResult.hasErrors()){
			
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage products");
			model.addAttribute("message2","please check your entries and try again");
			return "page";
		}
		
		logger.info(produit.toString());
		//create new product record
		if(produit.getId()==0){
			produitDAO.add(produit);
		}else{
			//update the product
			produitDAO.update(produit);
		}
		
	   //upload the file
		 if(!produit.getFile().getOriginalFilename().equals("") ){
			FileUploadUtility.uploadFile(request, produit.getFile(), produit.getCode()); 
		 }
	   
	   return "redirect:/admin/products?operation=product";
	}
	
	//return category for all the request mapping
	@ModelAttribute("categories")
	public List<Categorie> getCategories(){
		return categorieDAO.list();
	}
	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handlePostProductActivation(@PathVariable int id) {		
		Produit product = produitDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!isActive);
		produitDAO.update(product);		
		return (isActive)?
				 "Product Dectivated Successfully "+product.getId():
			     "Product Activated Successfully " +product.getId();
	}
	
	@RequestMapping(value = "/category", method=RequestMethod.POST)
	public String managePostCategory(@ModelAttribute Categorie category) {					
		categorieDAO.add(category);		
		return "redirect:/admin/products?operation=category";
	}
	

	
	@ModelAttribute("categories") 
	public List<Categorie> modelCategories() {
		return categorieDAO.list();
	}
	
	@ModelAttribute("category")
	public Categorie modelCategory() {
		return new Categorie();
	}
	
}
