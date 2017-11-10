package org.sid.e_commercebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.sid.e_commercebackend.beans.Categorie;
import org.sid.e_commercebackend.dao.CategorieDAO;

@Repository("categorieDAO")
@Transactional
public class CategorieDAOImp implements CategorieDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// private static List<Categorie> categories= new ArrayList<>();
	//
	// static {
	// Categorie categorie = new Categorie();
	// categorie.setId(1);
	// categorie.setDescription("desc");
	// categorie.setName("BMW");
	// categorie.setImageURL("cat1.jpg");
	// categories.add(categorie);
	//
	// categorie = new Categorie();
	// categorie.setId(2);
	// categorie.setDescription("desc");
	// categorie.setName("Peugeot");
	// categorie.setImageURL("cat2.jpg");
	// categories.add(categorie);
	//
	// categorie = new Categorie();
	// categorie.setId(3);
	// categorie.setDescription("desc");
	// categorie.setName("volkswagen");
	// categorie.setImageURL("cat2.jpg");
	// categories.add(categorie);
	// }
	// @Override
	// public List<Categorie> list() {
	// return categories;
	// }
	// @Override
	// public Categorie get(int id) {
	// for(Categorie categorie:categories){
	// if(categorie.getId()==id) return categorie;
	// }
	// return null;
	// }

	@Override
	public boolean add(Categorie categorie) {
		try {
			// add the category to database table
			sessionFactory.getCurrentSession().persist(categorie);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Categorie> list() {
		String req = "from Categorie where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(req);
		query.setParameter("active", true);
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	
	@Override
	public Categorie get(int id) {
		return sessionFactory.getCurrentSession().get(Categorie.class, Integer.valueOf(id));
	}

	/*
	 * Updating a single category
	 */
	@Override
	public boolean update(Categorie categorie) {
		try {
			sessionFactory.getCurrentSession().update(categorie);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Categorie categorie) {

		categorie.setActive(false);

		try {
			sessionFactory.getCurrentSession().update(categorie);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
