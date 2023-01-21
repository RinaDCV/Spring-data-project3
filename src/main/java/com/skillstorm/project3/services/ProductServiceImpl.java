package com.skillstorm.project3.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.project3.models.Product;
import com.skillstorm.project3.repositories.ProductRepository;

	@Service
	public class ProductServiceImpl implements ProductService{

		@Autowired
		private ProductRepository repository;

		@Override
		public Iterable<Product> findAll() {
			return repository.findAll();
		}
 
		@Override 
		public Product findById(int id) {
			Optional<Product> Product = repository.findById(id);
			return Product.isPresent() ? Product.get() : null;
		}


		// This method could work two ways:
		// 1. check if it exists already, if so don't overwrite it
		// 2. go ahead and save it, if it already exists it will be overwritten
		@Override
		public Product save(Product Product) { // The save implementation 
			// Method 1:
			if (!repository.existsById(Product.getId())) {
				System.out.println("Inside service save " + Product);
				Product createdProduct =  repository.save(Product);
				System.out.println("Created Product " + createdProduct);
				return createdProduct;
			}
			return Product;
		}

		// This method will be only slightly different
		// If the given id doesn't exist, don't do anything
		@Override
		public Product update(Product Product) {
			if (repository.existsById(Product.getId())) {
				return repository.save(Product); 
			}                                 
			return null; 
		}

		@Override
		public void deleteById(int id) {
			if (repository.existsById(id))
				repository.deleteById(id); 
		}

		@Override
		public void delete(Product Product) {
			repository.delete(Product);
		}

	}	
