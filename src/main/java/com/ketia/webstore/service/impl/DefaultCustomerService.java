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
import com.ketia.webstore.domain.Customer;
import com.ketia.webstore.domain.repository.CustomerRepository;
import com.ketia.webstore.service.CustomerService;

@Service
public class DefaultCustomerService implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
            return customerRepository.getAllCustoers();
	}

}
