package net.omar.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.omar.shoppingbackend.dao.CategoryDAO;
import net.omar.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.omar.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	/*
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is a description for Mobile");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));		
	}*/
	
	/*
	@Test
	public void testGetCategory(){
		category = categoryDAO.get(2);
		assertEquals("Successfully fetched a single Category from the table", "Laptop", category.getName());
	}*/
	
	/*
	@Test
	public void testUpdateCategory(){
		category = categoryDAO.get(2);
		category.setName("Laptop");
		assertEquals("Successfully updated a single Category", true, categoryDAO.update(category));
	}*/
	
	/*
	@Test
	public void testDeleteCategory(){
		category = categoryDAO.get(3);
		assertEquals("Successfully deleted a single Category", true, categoryDAO.delete(category));
	}*/
	
	/*
	@Test
	public void testListCategory(){
		assertEquals("Successfully fetched the list of categories from the table", 2, categoryDAO.list().size());
	}*/
	
	
	@Test
	public void testCRUDCategory(){
		
		//Add operation
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is a description for Mobile");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));		
		
		category = new Category();
		category.setName("Television");
		category.setDescription("This is a description for Television");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));		

		
		//fetching and updating the category
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated a single Category", true, categoryDAO.update(category));
		
		
		//Delete the category
		assertEquals("Successfully deleted a single Category", true, categoryDAO.delete(category));
		
		//fetch the list
		assertEquals("Successfully fetched the list of categories from the table", 1, categoryDAO.list().size());
		
	}
	
}
