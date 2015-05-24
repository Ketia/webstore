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

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.ketia.webstore.domain.Customer;
import com.ketia.webstore.domain.repository.CustomerRepository;

@Repository
public class DefaultCustomerRepository implements CustomerRepository { 
	private List<Customer> listCustomer = new ArrayList<Customer>();
	
	public DefaultCustomerRepository(){
		Customer cus1 = new Customer("001","Jim",2);
                Customer cus2 = new Customer("002","Razin",10);
                Customer cus3 = new Customer("003","Aho",7);
                listCustomer.add(cus1);
                listCustomer.add(cus2);
                listCustomer.add(cus3);
	}
	
	@Override
	public List<Customer> getAllCustoers() {
		return listCustomer;
	}
}
