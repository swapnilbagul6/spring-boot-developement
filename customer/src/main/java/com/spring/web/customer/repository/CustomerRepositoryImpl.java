package com.spring.web.customer.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.web.customer.dto.Customer;
import com.spring.web.customer.entity.CustomerEntity;

@Repository
@SuppressWarnings("all")

public class CustomerRepositoryImpl implements CustomerRepository{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<CustomerEntity> getAllCustomersFromDB() {
		Query query=entityManager.createQuery("select c from CustomerEntity c");
		List<CustomerEntity> list=query.getResultList();
		return list;
	}

	@Override
	public List<CustomerEntity> getCustomerByIDFromDB(Integer customer_id) {
		Query query=entityManager.createQuery("select c from CustomerEntity c where customer_id=?1");
		query.setParameter(1,customer_id);
		List<CustomerEntity> list=query.getResultList();
		return list;
	}

	@Override
	@Transactional
	public void AddOrUpdateCustomerToDB(Customer customer) {
		List<CustomerEntity> list=getCustomerByIDFromDB(customer.getCustomer_id());
		if(list.size()==0) {
			Query query =entityManager.createNativeQuery("insert into customer values(?,?,?)");
			query.setParameter(1, customer.getCustomer_id());
			query.setParameter(2, customer.getCustomer_name());
			query.setParameter(3, customer.getCustomer_location());
			query.executeUpdate();
		}
	}

}
