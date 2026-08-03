package com.amazon.service;

import java.util.Optional;
import java.util.logging.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.amazon.entity.ProductEntity;
import com.amazon.repository.ProductRepository;
import com.amazon.request.ProductRequest;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	
	public ProductEntity createProduct(ProductRequest request)
	{
		ProductEntity entity = new ProductEntity();
		
		entity.setProductName(request.getProductName());
		entity.setPrice(request.getPrice());
		entity.setQuantity(request.getQuantity());
		entity.setCategory(request.getCategory());
		
		ProductEntity productEntity = repository.save(entity);
		
		return productEntity;
	}
	
	@Cacheable (value = "Products", key = "#Id")
	public ProductEntity getProductById(String Id)
	{
		Optional<ProductEntity> product = repository.findById(Id);
		
		if(product.isPresent())
		{
						return  product.get();
 
		}
		else {
			return null;
			
		}
	}
	
	
	
	
	
}
