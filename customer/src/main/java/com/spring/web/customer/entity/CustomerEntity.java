package com.spring.web.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.web.customer.dto.Customer;

@Entity
@Table(name="customer")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customer_id;
	@Column
	private String customer_name;
	@Column
	private String customer_location;
	/* private BigInteger contact; */

	

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CustomerEntity(Integer customer_id, String customer_name, String customer_location) {
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
	
	public static CustomerEntity customerEntityToCustomer(Customer customer){
		CustomerEntity cust = new CustomerEntity();
		cust.setCustomer_id(customer.getCustomer_id());
		cust.setCustomer_name(customer.getCustomer_name());
		cust.setCustomer_location(customer.getCustomer_location());
		return cust;
	}
}
