/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ketia
 */
package com.ketia.webstore.domain;

public class Customer {
	private String customerId;
	private String name;
	private int noOfOrderMade;
	
	public Customer(String customerId, String name, int noOfOrderMade) {
		super();
		this.setCustomerId(customerId);
		this.setName(name);
		this.setNoOfOrderMade(noOfOrderMade);
	}
	
	public Customer(){
		this("","",0);
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfOrderMade() {
		return noOfOrderMade;
	}
	public void setNoOfOrderMade(int noOfOrderMade) {
		this.noOfOrderMade = noOfOrderMade;
	}
	
	
}

