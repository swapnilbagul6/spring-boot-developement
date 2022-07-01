package com.spring.web.customer.service;

import java.util.List;

import com.spring.web.customer.dto.Customer;
import com.spring.web.customer.exception.CustomerException;

public interface CustomerService {
	
	List<Customer> getAllCustomers();

	List<Customer> SearchCustomerByID(Integer customer_id) throws CustomerException;

	List<Customer> AddOrUpdateCustomer(Customer customer);

}
