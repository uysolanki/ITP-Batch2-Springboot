package com.itp.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itp.alibaba.model.Product;
import com.itp.alibaba.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping("/addProductByRequestParam")		//insert post mapping
	public Product addProductByRequestParam(@RequestParam("prodTitle") String prodTitle,
			@RequestParam("prodDesc") String prodDesc,
			@RequestParam("prodCategory") String prodCategory,
			@RequestParam("prodPrice") double prodPrice)
	{
		Product product=new Product();
		product.setProductTitle(prodTitle);
		product.setProductDesc(prodDesc);
		product.setProductCategory(prodCategory);
		product.setPrice(prodPrice);
		return productService.addProduct(product);
		//return "Product Added Successfully";
		
	}
	
	@PostMapping("/addProductByPathVariable/{a}/{b}/{c}/{d}")		//insert post mapping
	public Product addProductByPathVariable(@PathVariable("a") String prodTitle,
			@PathVariable("b") String prodDesc,
			@PathVariable("c") String prodCategory,
			@PathVariable("d") double prodPrice)
	{
		Product product=new Product();
		product.setProductTitle(prodTitle);
		product.setProductDesc(prodDesc);
		product.setProductCategory(prodCategory);
		product.setPrice(prodPrice);
		return productService.addProduct(product);
		//return "Product Added Successfully";
		
	}
	
	@PostMapping("/addProductByPathVariable2/{prodTitle}/{prodDesc}/{prodCategory}/{prodPrice}")		//insert post mapping
	public Product addProductByPathVariable2(@PathVariable String prodTitle,
			@PathVariable String prodDesc,
			@PathVariable String prodCategory,
			@PathVariable double prodPrice)
	{
		Product product=new Product();
		product.setProductTitle(prodTitle);
		product.setProductDesc(prodDesc);
		product.setProductCategory(prodCategory);
		product.setPrice(prodPrice);
		return productService.addProduct(product);
		//return "Product Added Successfully";
		
	}
	
	@PostMapping("/addProductByRequestBody")		//insert post mapping
	public Product addProductByRequestBody(@RequestBody Product product)
	{
		return productService.addProduct(product);
		
	}
}

/*
{
"pno": 3,
"productTitle": "Apple Iphone 16 Pro Max",
"productDesc": "IOS Mobile 8GB RAM 512 HDD",
"productCategory": "Electronics",
"price": 135000.0
}
9360275091
*/