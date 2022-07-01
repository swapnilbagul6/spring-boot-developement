package com.spring.web.customer.dto;

import java.util.List;

import com.spring.web.customer.entity.CustomerEntity;

public class Customer {
	
	private Integer customer_id;
	private String customer_name;
	private String customer_location;
	/* private BigInteger contact; */

	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customer(Integer customer_id, String customer_name, String customer_location) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_location = customer_location;
		
	}



	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	
	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_location() {
		return customer_location;
	}

	public void setCustomer_location(String customer_location) {
		this.customer_location = customer_location;
	}

	public static Customer customerEntityToCustomer(CustomerEntity customerEntity){
		Customer cust = new Customer();
		cust.setCustomer_id(customerEntity.getCustomer_id());
		cust.setCustomer_name(customerEntity.getCustomer_name());
		cust.setCustomer_location(customerEntity.getCustomer_location());
		return cust;
	}
	
}
