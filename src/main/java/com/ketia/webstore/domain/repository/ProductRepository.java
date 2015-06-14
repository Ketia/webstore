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
import java.util.Map;
import java.util.Set;

public interface ProductRepository {
    public List<Product> getAllProducts();
    public Product getProductById(String productID);
    public List<Product> getProductsByCategory(String category);
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParam);
    public List<Product> getProductsByManufacturer(String manufacturer);
    public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParam);
    public void addProduct(Product product);
}

