package com.itp.alibaba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.itp.alibaba.exception.ProductNotFoundException;
import com.itp.alibaba.model.Customer;
import com.itp.alibaba.model.Product;
import com.itp.alibaba.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		return productRepository.save(product);	
	}

	public Product getProduct(int pid) {
//		return productRepository.findById(pid).get();
		Optional<Product> product=productRepository.findById(pid); //Optional was introduced on java8 to eliminate null ptr ex
		if(product.isPresent())
			return product.get();
		else
			throw new ProductNotFoundException("Product with ID " + pid + " does not exist");
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Page<Product> productbypages(int pageNumber, int pageSize) {
		return productRepository.findAll(PageRequest.of(pageNumber, pageSize));
	}

	public Product updateProduct(int pid, Product newProductDetails) {
		Product prodDB=productRepository.findById(pid).get();
		prodDB.setPrice(newProductDetails.getPrice());
		prodDB.setProductCategory(newProductDetails.getProductCategory());
		prodDB.setProductDesc(newProductDetails.getProductDesc());
		prodDB.setProductTitle(newProductDetails.getProductTitle());
		return productRepository.save(prodDB);
	}

	public void deleteProduct(int pid) {
		productRepository.deleteById(pid);	
	}

}

