/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ketia
 */
package com.ketia.webstore.domain.repository.impl;

import com.ketia.webstore.domain.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.ketia.webstore.domain.Product;
import java.util.stream.Collectors;

/**
 * 	Spring Framework assigns the
	InMemoryProductRepository object to the productRepository reference.
	Spring creates and manages beans for "@Repository". As soon as Spring sees the "@Autowired" 
	annotation on top of the ProductRepository
	reference, it assigns the object of InMemoryProductRepository to this reference since
	Spring already created and holds the InMemoryProductRepository object in its object
	container (the web application context).
 */
@Repository
public class DefaultProductRepository implements ProductRepository{
	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public DefaultProductRepository() {
		Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		
		Product laptop_dell = new Product("P1235","Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron 14-inch Laptop(Black) with 3rd Generation Intel Core processors");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);
		
		Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 is the lightest7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Proprocessor");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);
		
		Product tablet_Asus = new Product("P1236","Asus Fire", new BigDecimal(670));
		tablet_Asus.setDescription("Amazon Asus Fire is the lightest7 inch tablet With a quad-core Qualcomm Snapdragon™ S7 Proprocessor");
		tablet_Asus.setCategory("Tablet");
		tablet_Asus.setManufacturer("AMAZON");
		tablet_Asus.setUnitsInStock(1600);
		
                Product iphone1 = new Product("P1234","iPhone 6+", new BigDecimal(500));
		iphone1.setDescription("Apple iPhone 6+ smartphone with 5.00-inch 840x1866 display and 12-megapixel rear camera");
		iphone1.setCategory("Smart Phone");
		iphone1.setManufacturer("Apple");
		iphone1.setUnitsInStock(500);
                
		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);
		listOfProducts.add(tablet_Asus);
                listOfProducts.add(iphone1);
	}
	public List<Product> getAllProducts() {
		return listOfProducts;
	}
	
	public Product getProductById(String productId) {
		Product productById = null;
		for(Product product : listOfProducts) {
			if(product!=null && product.getProductId()!=null && product.getProductId().equals(productId)){
				productById = product;
				break;
			}
		}
		if(productById == null){
			throw new IllegalArgumentException("No products found with the product id: "+ productId);
		}
		return productById;
	}

    @Override
    public List<Product> getProductsByCategory(String category) {
        return this.listOfProducts.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
}
