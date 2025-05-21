package com.itp.alibaba.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itp.alibaba.model.Product;
import com.itp.alibaba.response.ValidError;
import com.itp.alibaba.service.ProductService;



@Controller
public class ProductControllerFE {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/allproducts")
	String listOfProducts(Model model)
	{
		List<Product> products= productService.getAllProducts();
		model.addAttribute("products",products);
		return "list-of-products2";
	}
	
	
	@RequestMapping("/addproductform")
	String addProductsForm(Model model)
	{
		Product product=new Product();
		model.addAttribute("product",product);
		return "add-product-form";
	}
	
	@PostMapping("/addProduct")		//insert post mapping
	public String addProductByRequestBody(@ModelAttribute Product product)
	{
		productService.addProduct(product);
		return "redirect:/allproducts";
		
	}
	
	@RequestMapping("/deleteProductFE/{pid}")		//insert post mapping
	public String deleteProduct(@PathVariable int pid)
	{
		productService.deleteProduct(pid);
		return "redirect:/allproducts";
	}
	
	@RequestMapping("/updateProductForm/{pid}")		//insert post mapping
	public String updateProductForm(@PathVariable int pid,Model model)
	{
		Product product= productService.getProduct(pid);
		model.addAttribute("product",product);
		return "add-product-form";
	}
	
	
//	@RequestMapping("/updateProduct/{pid}")
//	public ResponseEntity<Product> updateProduct(@PathVariable int pid,@RequestBody Product newProductDetails)
//	{
//		return new ResponseEntity<Product>(productService.updateProduct(pid,newProductDetails),HttpStatus.CREATED);
//	}
}