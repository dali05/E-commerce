package org.sid.e_commercebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.RespectBinding;

import org.sid.e_commercebackend.beans.Categorie;
import org.sid.e_commercebackend.dao.CategorieDAO;
import org.springframework.stereotype.Repository;

@Repository("categorieDAo")
public class CategorieDAOImp implements CategorieDAO {
	
	private static List<Categorie> categories= new ArrayList<>();
	
	static {
		Categorie categorie = new Categorie();
		categorie.setId(1);
		categorie.setDescription("desc");
		categorie.setName("BMW");
		categorie.setImageURL("cat1.jpg");
		categories.add(categorie);
		
		categorie = new Categorie();
		categorie.setId(2);
		categorie.setDescription("desc");
		categorie.setName("Peugeot");
		categorie.setImageURL("cat2.jpg");
		categories.add(categorie);
		
		categorie = new Categorie();
		categorie.setId(3);
		categorie.setDescription("desc");
		categorie.setName("volkswagen");
		categorie.setImageURL("cat2.jpg");
		categories.add(categorie);
	}
	@Override
	public List<Categorie> list() {
		return categories;
	}
	@Override
	public Categorie get(int id) {
		for(Categorie categorie:categories){
			if(categorie.getId()==id) return categorie;
		}
		return null;
	}

}
