package com.itp.alibaba.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itp.alibaba.model.Product;
import com.itp.alibaba.response.ValidError;
import com.itp.alibaba.service.ProductService;



@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	private static final Logger logger=Logger.getLogger(ProductController.class);

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
	public ResponseEntity<?> addProductByRequestBody(@RequestBody @Valid Product product,BindingResult bindingResult)
	{
		logger.info("Request received for adding product " + product.getProductTitle());
		 if (bindingResult.hasErrors()) 
			{
			 List<ValidError> errors = new ArrayList<>();
			 for (FieldError error : bindingResult.getFieldErrors()) 
				{
				 ValidError apiError = new ValidError(error.getDefaultMessage(), error.getField(), error.getRejectedValue());
			     errors.add(apiError);
			     }
			 return new ResponseEntity<List<ValidError>>(errors,HttpStatus.BAD_REQUEST);

			}
		
		return new ResponseEntity<Product>(productService.addProduct(product),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/product/{pid}")		//insert post mapping
	public ResponseEntity<Product> getProduct(@PathVariable int pid)
	{
		Product product= productService.getProduct(pid);
		return new ResponseEntity<Product>(product,HttpStatus.FOUND);
	}
	
	@GetMapping("/product")		//insert post mapping
	public List<Product> getProducts()
	{
		List<Product> products= productService.getAllProducts();
		return products;
	}
	
	@GetMapping("/productbypages/{pageNumber}/{pageSize}")		//insert post mapping
	public Page<Product> productbypages(@PathVariable int pageNumber,@PathVariable int pageSize)
	{
		Page<Product> products= productService.productbypages(pageNumber,pageSize);
		return products;
	}
	
	@GetMapping("/try1")		//insert post mapping
	public ResponseEntity<?> test()
	{
		int n=9;
		if(n%2==0)
		{
			return new ResponseEntity<Integer>(101,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Test",HttpStatus.OK);
		}
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