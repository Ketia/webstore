package com.ketia.webstore.controller;


import com.ketia.webstore.domain.Product;
import com.ketia.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ketia
 */
/**
 *	Provide "@Controller" annotation for Spring to scan for Controller Class of the Products page
 */
@Controller
public class ProductController {
	/**
	 * 	Spring sees the "@Autowired" annotation on top of the ProductRepository
		reference, it assigns the object of InMemoryProductRepository to this reference since
		Spring already created and holds the InMemoryProductRepository object in its object
		container (the web application context).
	 */
	@Autowired
	private ProductService productService;
	
	/**
	 * 	By using "@RequestMapping("/products"), it will tell the Dispatcher that this controller's going to return the Model attribute "products" to 
	 * 	matching jsp page "/webstore/products.jsp". 
	 */
	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());

		Product iphone1 = new Product("P1234","iPhone 6+", new BigDecimal(500));
		iphone1.setDescription("Apple iPhone 6+ smartphone with 5.00-inch 840x1866 display and 12-megapixel rear camera");
		iphone1.setCategory("Smart Phone");
		iphone1.setManufacturer("Apple");
		iphone1.setUnitsInStock(500);
		model.addAttribute("product1", iphone1);
		
		return "products";
	}
}