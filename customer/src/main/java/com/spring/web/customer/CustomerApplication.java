package com.spring.web.customer;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApplication {

	public static String message="";
	public static Logger log=org.slf4j.LoggerFactory.getLogger(CustomerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
