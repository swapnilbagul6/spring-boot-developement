package com.spring.web.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.customer.CustomerApplication;
import com.spring.web.customer.dto.Customer;
import com.spring.web.customer.entity.CustomerEntity;
import com.spring.web.customer.exception.CustomerException;
import com.spring.web.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<>();
		List<CustomerEntity> list = customerRepository.getAllCustomersFromDB();
		for (CustomerEntity customerEntity : list) {
			Customer customer = Customer.customerEntityToCustomer(customerEntity);
			customerList.add(customer);
		}
		return customerList;
	}

	@Override
	public List<Customer> SearchCustomerByID(Integer customer_id) throws CustomerException {
		List<Customer> customerList = new ArrayList<>();
		List<CustomerEntity> list = customerRepository.getCustomerByIDFromDB(customer_id);
		if(list.size()>0) {
		for (CustomerEntity customerEntity : list) {
			Customer customer = Customer.customerEntityToCustomer(customerEntity);
			customerList.add(customer);
		}
		CustomerApplication.message="";
		return customerList;
		}else {
			CustomerApplication.message="The Customer Id is not associated with any Customer";
			throw new CustomerException(CustomerApplication.message);
		}
	}

	@Override
	public List<Customer> AddOrUpdateCustomer(Customer customer) {
		List<Customer> customerList = new ArrayList<>();
		customerRepository.AddOrUpdateCustomerToDB(customer);
		List<CustomerEntity> list = customerRepository.getAllCustomersFromDB();
		for (CustomerEntity customerEntity : list) {
			Customer customerdto = Customer.customerEntityToCustomer(customerEntity);
			customerList.add(customerdto);
		}
		return customerList;
	}

}
