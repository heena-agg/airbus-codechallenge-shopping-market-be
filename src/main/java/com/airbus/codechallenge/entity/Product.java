package com.airbus.codechallenge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product")
public class Product implements Comparable<Product>{
	
	//@JsonIgnore
	//private static int productCount = 5;
	
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long productId;
	
	@Column(name="category")
	private String category;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="units")
	private int units;
	
	
	public Product() {
		super();
	}
	
	public Product(String category, String productName, String productDescription, int units) {
		super();
		this.category = category;
		this.productName = productName;
		this.productDescription = productDescription;
		this.units = units;
	}
	
	
	public Long getProductId() {
		return productId;				//"P" + ++productCount;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", category=" + category + ", productName=" + productName
				+ ", productDescription=" + productDescription + ", units=" + units + "]";
	}

	@Override
	public int compareTo(Product product) {
		// TODO Auto-generated method stub
		if(this.productName.equals(product.getProductName()) 
				&& this.productDescription.equals(product.getProductDescription()) 
				&& this.category.equals(product.getCategory()))
		{
			return 0;
		}else {
			return -1;
		}
		
	}	

}

