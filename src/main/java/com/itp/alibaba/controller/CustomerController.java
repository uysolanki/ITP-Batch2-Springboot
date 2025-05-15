package com.itp.alibaba.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itp.alibaba.model.Customer;
import com.itp.alibaba.model.Product;
import com.itp.alibaba.response.ValidError;
import com.itp.alibaba.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	private static final Logger logger=Logger.getLogger(CustomerController.class);

	@PostMapping("/addCustomer")		//insert post mapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		logger.info("Request received for adding Customer " + customer.getCustName());
		 
		return new ResponseEntity<Customer>(customerService.addCustomer(customer),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updateCustomer/{cid}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int cid,@RequestBody Customer newCustomerDetails)
	{
		logger.info("Request received for Updating Customer " + newCustomerDetails.getCustName());
		 
		return new ResponseEntity<Customer>(customerService.updateCustomer(cid,newCustomerDetails),HttpStatus.CREATED);
	}
}
