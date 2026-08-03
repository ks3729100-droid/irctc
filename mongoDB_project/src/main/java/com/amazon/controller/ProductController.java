package com.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.entity.ProductEntity;
import com.amazon.request.ProductRequest;
import com.amazon.service.ProductService;


@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@PostMapping("/createProducts")
	public ProductEntity createProducts(@RequestBody ProductRequest request)
	{
		ProductEntity name = service.createProduct(request);
		return name;
	}
	
	@GetMapping("/getProduct")
	public ProductEntity getProductById(@RequestParam String Id)
	{
		ProductEntity pro = service.getProductById(Id);
		return pro;
	}

}
