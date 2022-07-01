package com.spring.web.customer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.customer.CustomerApplication;
import com.spring.web.customer.dto.Customer;
import com.spring.web.customer.exception.CustomerException;
import com.spring.web.customer.service.CustomerService;

@Controller
@RequestMapping(value="/customer/")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String landingHomePage(Model model) {
				List<Customer> list=customerService.getAllCustomers();
				model.addAttribute("customerList", list);
				return "home";
	}
	@RequestMapping(value="/search/",method=RequestMethod.POST)
	public String searchCustomerById(Model model,@RequestParam("customer_id_search") Integer customer_id) {
				List<Customer> list = new ArrayList<>();
				try {
					list = customerService.SearchCustomerByID(customer_id);
				} catch (CustomerException e) {
					CustomerApplication.log.info(e.getMessage());
				}
				model.addAttribute("message",CustomerApplication.message);
				model.addAttribute("customerList", list);
				return "home";
	}
	
	@RequestMapping(value="/addcustomer/",method=RequestMethod.POST)
	public String addNewCustomer(Model model,@ModelAttribute("customer") Customer customer) {
				List<Customer> list=customerService.AddOrUpdateCustomer(customer);
				model.addAttribute("customerList", list);
				return "home";
	}

}
