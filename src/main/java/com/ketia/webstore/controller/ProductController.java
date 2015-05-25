package com.ketia.webstore.controller;


import com.ketia.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
@RequestMapping("/products")
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
     *      @RequestMapping called call Class level annotation
     * http://localhost:8080/webstore/products 
     */
    @RequestMapping
    public String list(Model model) {
            model.addAttribute("products", productService.getAllProducts());
            return "products";
    }

    /**
     *      @RequestMapping("/all") called call Method level annotation
     * http://localhost:8080/webstore/products/all
     * @param model
     * @return 
     */
    @RequestMapping("/all")
    public String allProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
        
    /**
     * we can define a common URI template for the previously mentioned URLs, which might
     *   look like http://localhost:8080/webstore/products/{category}. Spring MVC
     *  can leverage this fact and make that template portion ({category}) of the URL a variable,
     *  called a path variable(@PathVariable) in the Spring world.
     */ 
    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, 
                                        @PathVariable("category") String productCategory){
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }
}