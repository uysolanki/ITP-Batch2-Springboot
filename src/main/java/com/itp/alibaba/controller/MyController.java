package com.itp.alibaba.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "virat1";
	}
	
	
}
