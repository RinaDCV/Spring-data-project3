package com.skillstorm.project3.services;

import com.skillstorm.project3.models.Product;

public interface ProductService {

	Iterable<Product> findAll();
	Product findById(int id);
	Product save(Product aircraft);
	Product update(Product aircraft);
	void delete(Product aircraft);
	void deleteById(int id);
	

}
