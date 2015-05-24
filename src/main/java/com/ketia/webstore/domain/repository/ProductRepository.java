/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ketia
 */
package com.ketia.webstore.domain.repository;

import java.util.List;

import com.ketia.webstore.domain.Product;

public interface ProductRepository {
	public List<Product> getAllProducts();
	public Product getProductById(String productID);
}

