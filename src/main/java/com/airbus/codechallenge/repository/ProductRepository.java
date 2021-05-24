package com.airbus.codechallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airbus.codechallenge.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Product findByProductId(Long productId);

	List<Product> findByCategoryIgnoreCase(String category);
}
