package com.airbus.codechallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.ObjectUtils;

import com.airbus.codechallenge.constants.ErrorMessage;
import com.airbus.codechallenge.entity.Product;
import com.airbus.codechallenge.exception.ResourceAlreadyExistException;
import com.airbus.codechallenge.exception.ResourceNotFoundException;
import com.airbus.codechallenge.repository.ProductRepository;

@Service
public class ProductService {	
	
	@Autowired
	private ProductRepository productRepository;

	
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}
	
	public Product getProduct(Long productId)
	{
		Product product = productRepository.findByProductId(productId);
		if(!ObjectUtils.isEmpty(product)) {
			return product;
		}
		else {
			throw new ResourceNotFoundException(ErrorMessage.PRODUCT_NOT_FOUND + productId);
		}
	}
	
	
	public List<Product> getCategoryProduct(String category) 
	{
		return productRepository.findByCategoryIgnoreCase(category);		
	}
	
	
	public Product createProduct(Product product)
	{
		int count = (int) productRepository.findAll().stream()
			.filter(x ->  x.getProductName().equals(product.getProductName()) && x.getProductDescription().equals(product.getProductDescription()) )
			.count();
		
		if(count == 0 ) {
			return productRepository.save(product);
		}else {
			throw new ResourceAlreadyExistException(ErrorMessage.PRODUCT_ALREADY_EXIST + product.toString());
		}
			
			
		
	}
	
	
	public Product updateProduct(Long productId, Product product)
	{
		Product existingProduct = productRepository.findByProductId(productId);
		if(ObjectUtils.isEmpty(existingProduct)) {
			throw new ResourceNotFoundException(ErrorMessage.PRODUCT_NOT_FOUND + productId);
		}else {
			existingProduct.setCategory(product.getCategory());
			existingProduct.setProductDescription(product.getProductDescription());
			existingProduct.setProductName(product.getProductName());
			existingProduct.setUnits(product.getUnits());
			return productRepository.save(existingProduct);
		}
										
	}

}
