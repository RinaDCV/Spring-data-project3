package com.skillstorm.project3.services;

import java.util.List;

import com.skillstorm.project3.models.CustomException;

import com.skillstorm.project3.models.Aircraft;
import com.skillstorm.project3.models.Product;

public interface ProductService {

	Iterable<Product> findAll();
	
	Product findById(int id) throws CustomException;
	
	Iterable<Product> findByName(String name);
	
	Product save(Product product) throws CustomException;
	
	Product update(Product product, int id) throws CustomException;
	
	void delete(Product product);
	
	void deleteById(int id);
	
	void deleteAll(List<Product> products);
	
	Iterable<Aircraft> findAircraftByProductId(int id);
	
	Iterable<Product> findByDescriptionContaining(String name);



}
