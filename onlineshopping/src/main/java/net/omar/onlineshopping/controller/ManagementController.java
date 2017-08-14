package net.omar.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

import net.omar.onlineshopping.util.FileUploadUtility;
import net.omar.onlineshopping.validator.ProductValidator;
import net.omar.shoppingbackend.dao.CategoryDAO;
import net.omar.shoppingbackend.dao.ProductDAO;
import net.omar.shoppingbackend.dto.Category;
import net.omar.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value = "/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		if (operation != null){
			if (operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
		}
		
		return mv;
	}
	
	
	@RequestMapping(value="{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {
		
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product product = productDAO.get(id);	
		//set the product fetched from the database
		mv.addObject("product", product);
		
		return mv;
	}
	
	//handling product submission
	@RequestMapping(value = "/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute ("product")Product mProduct
			, BindingResult results, Model model, HttpServletRequest request) {
		
		//handle image validation for new products
		if(mProduct.getId() == 0){
			new ProductValidator().validate(mProduct, results);
		}else {
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		if(results.hasErrors()) {
			
			//this model parameter is to pass anything to the view
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for product Submission!");
			//we cant use redirect because the error will not be displayed
			return "page";
		}
		
		
		logger.info(mProduct.toString());
		
		//Create a new product record in the database
		if(mProduct.getId() == 0){
			productDAO.add(mProduct);
		}else{//update the product if id is not 0
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id){
		
		Product product = productDAO.get(id);
		
		boolean isActive = product.isActive();
		product.setActive(!isActive);
		productDAO.update(product);
		
		return (isActive)? "You have Successfully deactivated the product with id " + id :
							"You have Successfully activated the product with id " + id;
	}
	
	
	//returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}
	
	
}
