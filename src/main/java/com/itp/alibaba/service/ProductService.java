package com.itp.alibaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.alibaba.model.Product;
import com.itp.alibaba.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		return productRepository.save(product);	
	}

}

