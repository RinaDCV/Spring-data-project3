package com.skillstorm.project3.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.project3.models.CustomException;
import com.skillstorm.project3.models.Product;

import com.skillstorm.project3.models.Aircraft;
import com.skillstorm.project3.repositories.ProductRepository;

	@Service
	public class ProductServiceImpl implements ProductService{

		@Autowired
		ProductRepository repo;
		
		Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

		@Override
		public Iterable<Product> findAll() {
			return repo.findAll();
		}

		@Override
		public Product findById(int id) throws CustomException {
			Optional<Product> result =  repo.findById(id); // you could store the optional and do a ifPresent() check then .get() else return null
			if (!result.isPresent())
				throw new CustomException("No product exists with id of " + id + ".");
			return result.get();
		}



		@Override
		public Product update(Product product, int id) throws CustomException {
			if (!repo.existsById(id)) {
				throw new CustomException("Update didn't work bc there is no existing record with the given id " + id +"."); // TODO make a custom exception to throw here
			} else {
				product.setId(id);
				return repo.save(product);
			}
		}

		@Override
		public void delete(Product product) {
			repo.delete(product);
		}

		@Override
		public void deleteById(int id) { // TODO we could let it throw the error and add to our GlobalExceptionHanlder class a method to create the HTTP response in this situation
			if (repo.existsById(id)) // this is to make our deletebyid more rebust (ex: if we run this twice in a row by accident)
				repo.deleteById(id); // this is throwing an error if we try to delete a nonexistent row 
		}

		@Override
		public void deleteAll(List<Product> products) {
			repo.deleteAll(products);
		}

		@Override
		public Iterable<Product> findByName(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Product save(Product product) throws CustomException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Aircraft> findAircraftByProductId(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Product> findByDescriptionContaining(String name) {
			// TODO Auto-generated method stub
			return null;
		}



	}