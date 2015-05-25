/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ketia
 */
package com.ketia.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ketia.webstore.domain.Product;
import com.ketia.webstore.domain.repository.ProductRepository;
import com.ketia.webstore.service.ProductService;

@Service
public class DefaultProductService implements 
	ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

    @Override
    public List<Product> getProductsByCategory(String category) {
        return this.productRepository.getProductsByCategory(category);
    }
}

