package org.sid.e_commercebackend.dao;

import java.util.List;

import org.sid.e_commercebackend.beans.Produit;

public interface ProduitDAO {

	Produit get(int ProduitId);
	List<Produit> list();	
	boolean add(Produit produit);
	boolean update(Produit Produit);
	boolean delete(Produit Produit);

	List<Produit> getProductsByParam(String param, int count);	
	
	
	// business methods
	List<Produit> listActiveProducts();	
	List<Produit> listActiveProductsByCategory(int categoryId);
	List<Produit> getLatestActiveProducts(int count);
	
}
