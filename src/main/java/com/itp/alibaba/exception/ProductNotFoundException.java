package com.itp.alibaba.exception;

public class ProductNotFoundException extends RuntimeException
{
	public ProductNotFoundException(String errorMsg)
	{
		super(errorMsg);
	}
}
