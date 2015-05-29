/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ketia
 */
package com.ketia.webstore.service;

import java.util.List;
import com.ketia.webstore.domain.Product;
import java.util.Map;
import java.util.Set;

public interface ProductService {
	public List<Product> getAllProducts();
        public List<Product> getProductsByCategory(String category);
        public Set<Product> getProductsByFilter(Map<String, List<String>> filterParam);
        public Product getProductById(String productID);
}