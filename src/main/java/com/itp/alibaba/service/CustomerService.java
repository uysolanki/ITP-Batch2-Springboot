package com.itp.alibaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.alibaba.model.Customer;
import com.itp.alibaba.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	public Customer updateCustomer(int cid, Customer newCustomerDetails) {
		Customer custDB=customerRepository.findById(cid).get();
		custDB.setCustGender(newCustomerDetails.getCustGender());
		custDB.setCustEmail(newCustomerDetails.getCustEmail());
		custDB.setCustMobile(newCustomerDetails.getCustMobile());
		custDB.setCustName(newCustomerDetails.getCustName());
		return customerRepository.save(custDB);
	}

}
