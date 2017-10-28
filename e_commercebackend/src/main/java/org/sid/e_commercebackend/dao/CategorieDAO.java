package org.sid.e_commercebackend.dao;

import java.util.List;

import org.sid.e_commercebackend.beans.Categorie;

public interface CategorieDAO {

	List<Categorie> list();
	Categorie get(int id);
}
