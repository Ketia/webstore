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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ketia.webstore.domain.Product;
import com.ketia.webstore.domain.repository.ProductRepository;
import com.ketia.webstore.service.OrderService;

@Service
public class DefaultOrderService implements OrderService{
	@Autowired
	private ProductRepository productRepository;
	
	public void processOrder(String productId, int quantity) {
		Product productById = productRepository.getProductById(productId);
		if(productById.getUnitsInStock() < quantity){
			throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
	}
}

