package com.itp.alibaba.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itp.alibaba.model.Product;
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
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			    "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

	
//	@RequestMapping("/updateProduct/{pid}")
//	public ResponseEntity<Product> updateProduct(@PathVariable int pid,@RequestBody Product newProductDetails)
//	{
//		return new ResponseEntity<Product>(productService.updateProduct(pid,newProductDetails),HttpStatus.CREATED);
//	}
}