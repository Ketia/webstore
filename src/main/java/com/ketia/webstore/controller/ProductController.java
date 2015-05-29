package com.ketia.webstore.controller;


import com.ketia.webstore.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    /**
     * @MatrixVariable
     * A URL can have multiple matrix variables; each matrix variable will be
        separated with a ; (semicolon). To assign multiple values to a single variable,
        each value must be separated by a "," (comma), or we can repeat the variable
        name. See the following URL, which is a repeated variable version of the same
        URL that we used in our example:
        http://localhost:8080/webstore/products/filter/
        ByCategory;brand=google;brand=dell;category=tablet;
        category=laptop
        Note that we repeated the variables brand and category twice in the URL.
        * Spring MVC will read all the matrix variables found in the URL after the {ByCriteria}
        URI template and place those matrix variables into the map of the method parameter
        filterParams. The filterParams map will have each matrix variable name as key and
        the corresponding list will contain the multiple values assigned for the matrix variable. The
        pathVar attribute from the @MatrixVariable annotation is used to identify the matrix
        variable segment in the URL; that's why it has the value ByCriteria, which is nothing but
        the URI template value that we used in our request mapping URL.
        A URL can have multiple matrix variable segments. Take a look at the following URL:
        http://localhost:8080/webstore/products/filter/ByCriteria;brand=googl
        e,dell;category=tablet,laptop/BySpecification;dimention=10,20,15;colo
        r=red,green,blue
        * To enable the use of matrix variables in Spring MVC, we set the enable-matrix-variables
        attribute of the <mvc:annotation-driven> tag to true
     */
    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParam,
                                        Model model){
        model.addAttribute("products", productService.getProductsByFilter(filterParam));
        return "products";
    }
    /**
     * @RequestParam
     * Matrix variables and path variables are a great way of binding variables in the URL request
        path. However, there is one more way to bind variables in the HTTP request, not only as a
        part of the URL but also in the body of the HTTP web request, which are the so-called HTTP
        parameters. You might have heard about the GET or POST parameters. GET parameters have
        been used for years as a standard way to bind variables in the URL, and POST parameters are
        used to bind variables in the body of the HTTP request. We will learn about POST parameters
        in the next chapter during form submission.
        Okay, now let's see how to read GET request parameters using the Spring MVC style.
        * since we annotated the parameter
        productId with the @RequestParam("id") annotation (org.springframework.web.
        bind.annotation.RequestParam), Spring MVC will try to read a GET request parameter
        with the name id from the URL and assign it to the getProductById method parameter,
        productId.
        * The @RequestParam annotation also follows the same convention for other binding
        annotations; that is, if the name of the GET request parameter and the name of the variable
        it is annotated with are the same, then there will be no need to specify the value attribute in
        the @RequestParam annotation.
        * We saw how to retrieve a GET request parameter from the URL, but how do we pass more
        than one GET request parameter in the URL? The answer is that we need to delimit each
        parameter value pair with an & symbol; for example, if we want to pass category and
        price as GET request parameters in a URL, we have to form the URL as follows:
        http://localhost:8080/WebStore/products/product?category=laptop&pri
        ce=700
        Similarly, to map the preceding URL in a request mapping method, our request mapping
        method should have at least two parameters with the @RequestParam annotation:
        public String getProducts(@RequestParam String category,
        @RequestParam String price) {
     */
    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId,
                                    Model model){
        model.addAttribute("product",productService.getProductById(productId));
        return "product";
    }
}