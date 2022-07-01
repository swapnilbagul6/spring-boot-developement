package com.spring.web.customer.repository;

import java.util.List;

import com.spring.web.customer.dto.Customer;
import com.spring.web.customer.entity.CustomerEntity;

public interface CustomerRepository {

	List<CustomerEntity> getAllCustomersFromDB();

	List<CustomerEntity> getCustomerByIDFromDB(Integer customer_id);

	void AddOrUpdateCustomerToDB(Customer customer);
}
