package com.itp.alibaba.model;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pno;
	
	@NotNull(message = "Product Title cannot be null")
	@Size(min = 2, max = 100, message = "Product Title must be between 2 and 100 characters") 
	private String productTitle;
	
	@NotNull(message = "Product Description cannot be null")
	@Size(min = 2, max = 200, message = "Product Description must be between 2 and 100 characters") 
	private String productDesc;
	
	@NotNull(message = "Product Category Description cannot be null")
	@NotEmpty(message = "Product Category cannot be empty")
	@Column(unique = true)
	private String productCategory;
	
	@NotNull(message = "Price cannot be null") 
	@Min(value = 100, message = "Price must be at least 10,000") 
	@Max(value = 50000, message = "Price must be less than or equal to 50,000") 
	private double price;
	

}
