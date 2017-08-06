package net.omar.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.omar.shoppingbackend.dao.ProductDAO;
import net.omar.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.omar.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	
	@Test
	public void testCRUDProduct(){
		
		//Add operation
		product = new Product();
		product.setName("iPhone s6");
		product.setBrand("iPhone");
		product.setDescription("This is a description for iPhone s6");
		product.setUnitPrice(250);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Error when inserting a product", 
				true, productDAO.add(product));		
		
		//fetching and updating the product
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Error when updating a product", 
				true, productDAO.update(product));
		
		
		//Delete the product
		assertEquals("Error when deleting a product", 
				true, productDAO.delete(product));
		
		//fetch the list
		assertEquals("Error when getting the products", 
				6, productDAO.list().size());
		
	}
	
	@Test
	public void testlistActiveProducts(){
		assertEquals("Error when getting the list of Active Products", 
				5, productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testlistActiveProductsByCategory(){
		assertEquals("Error when getting the list of Active Products by category", 
				2, productDAO.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void testgetLatestAvtiveProducts(){
		assertEquals("Error when getting the latest Active Products", 
				2, productDAO.getLatestAvtiveProducts(2).size());
	}
	
}
