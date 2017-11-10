package org.sid.e_commercebackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.sid.e_commercebackend.beans.Produit;
import org.sid.e_commercebackend.dao.ProduitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("produitDAO")
@Transactional
public class ProduitDAOImpl implements ProduitDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * SINGLE
	 * */
	
	@Override
	public Produit get(int productId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Produit.class,Integer.valueOf(productId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	/*
	 * LIST
	 * */
	
	@Override
	public List<Produit> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Produit" , Produit.class)
						.getResultList();
	}

	/*
	 * INSERT
	 * */
	@Override
	public boolean add(Produit produit) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(produit);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	/*
	 * UPDATE
	 * */
	@Override
	public boolean update(Produit produit) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(produit);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		
	}

	
	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Produit produit) {
		try {
			
			produit.setActive(false);
			// call the update method
			return this.update(produit);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;			
	}

	@Override
	public List<Produit> listActiveProducts() {
		String selectActiveProducts = "FROM Produit WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts, Produit.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Produit> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Produit WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Produit.class)
						.setParameter("active", true)
						.setParameter("categoryId",categoryId)
							.getResultList();
	}

	@Override
	public List<Produit> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Produit WHERE active = :active ORDER BY id", Produit.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();					
	}

	@Override
	public List<Produit> getProductsByParam(String param, int count) {
		
		String query = "FROM Produit WHERE active = true ORDER BY " + param + " DESC";
		
		return sessionFactory
					.getCurrentSession()
					.createQuery(query,Produit.class)
					.setFirstResult(0)
					.setMaxResults(count)
					.getResultList();
					
		
	}

}
