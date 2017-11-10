package org.sid.e_commercebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.sid.e_commercebackend.beans.Categorie;
import org.sid.e_commercebackend.dao.CategorieDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTest {
	private static AnnotationConfigApplicationContext context;
	private static CategorieDAO categorieDAO;
	private Categorie categorie;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.sid.e_commercebackend");
		context.refresh();
		categorieDAO = (CategorieDAO)context.getBean("categorieDAO");
	}

//	@Test
//	public void testAddCategorie() {
//		categorie = new Categorie();
//		categorie.setDescription("desc");
//		categorie.setName("dali");
//		categorie.setImageURL("cat1.jpg");
//		assertEquals("successfully added a category inside the table",
//				       true, categorieDAO.add(categorie));
//	}
	
//	@Test
//	public void testGetGategory(){
//		categorie = categorieDAO.get(3);
//		assertEquals("successfully fetched a single category from  the table","Peugeot",
//			       categorie.getName());
//	}
	
//	@Test
//	public void testUpdateCategorie(){
//		categorie = categorieDAO.get(3);
//		categorie.setName("Peugeot");
//		assertEquals("successfully updated a single category in the table",true,
//			       categorieDAO.update(categorie));
//	}
	
//	@Test
//	public void testDeleteCategorie(){
//		categorie = categorieDAO.get(5);
//		assertEquals("successfully deleted a single category in the table",true,
//			       categorieDAO.delete(categorie));
//	}
	
//	@Test
//	public void testListCategorie(){
//		categorie = categorieDAO.get(5);
//		assertEquals("successfully fetched the list of categories from the table",3,
//			       categorieDAO.list().size());
//	}
	
}
