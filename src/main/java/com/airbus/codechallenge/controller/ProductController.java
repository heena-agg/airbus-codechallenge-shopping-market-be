package com.airbus.codechallenge.controller;

import java.net.URI;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.airbus.codechallenge.entity.Product;
import com.airbus.codechallenge.service.ProductService;

/**
 * @author ina607heeagar
 *
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Get all products
	 * 
	 * @return product list
	 */	
	@GetMapping("/product")	
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	/**
	 * Get product based on id
	 * 
	 * @param productId
	 * @return product if exist for the given id else throw ProductNotFoundException
	 */
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable(value = "id") Long productId) {
		return productService.getProduct(productId);
	}

	/**
	 * Get product list based on category
	 * 
	 * @param category
	 * @return product list
	 */
	// validate category from the enum -else give empty list for wrong category
	@GetMapping("/product/category/{categoryName}")
	public List<Product> getCategoryProducts(@PathVariable(value = "categoryName") String category) {
		return productService.getCategoryProduct(category);
	}

	/**
	 * create product
	 * 
	 * @param product
	 * @return status 201 if created else throw ProductAlreadyExistException
	 */
	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product persistedProduct = productService.createProduct(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(persistedProduct.getProductId()).toUri();
		return ResponseEntity.created(location).build();
	}

	/**
	 * Update product based on id
	 * 
	 * @param productId
	 * @param product
	 * @return status 200 if updated else throw productNotFoundException
	 */
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
			@RequestBody Product product) {

		Product updatedProduct = productService.updateProduct(productId, product);
		return ResponseEntity.ok(updatedProduct);

	}

}
