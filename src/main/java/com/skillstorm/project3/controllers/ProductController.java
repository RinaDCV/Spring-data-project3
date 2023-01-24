package com.skillstorm.project3.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project3.models.CustomException;
import com.skillstorm.project3.models.Product;
import com.skillstorm.project3.models.Aircraft;
import com.skillstorm.project3.services.ProductService;

@RestController
@Controller
@RequestMapping("/product")
@CrossOrigin(origins = "*") // later u can change to * //allows frontend and backend to communicate
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping
	public Iterable<Product> findAll(@RequestParam(name = "Nomenclature", required = false) String nomenclature, 
									@RequestParam(name = "Warehouse_id", required = false) String warehouse_id) {
		if (nomenclature != null)
			return service.findByName(nomenclature); 
		if (warehouse_id != null)
			return service.findByDescriptionContaining(warehouse_id);
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) throws CustomException {
		return service.findById(id);
	}
	
	@GetMapping("/{id}/shops")
	public Iterable<Aircraft> findStoresByProductId(@PathVariable int id) {
		return service.findAircraftByProductId(id);
	}
	

	// 200 successful or 404 not found or 400 bad request if couldn't find it
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable int id) throws CustomException {
		Product result = service.update(product, id);
//		if (result == null)
//			return ResponseEntity.notFound().build(); 
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product save(@RequestBody Product product) throws CustomException {
		return service.save(product);
		
	}
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@RequestBody Product product) {
		service.delete(product);
	}
	
	@DeleteMapping("/{id}") 
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delte(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@DeleteMapping("/all") // not the best solution, TODO handle the ambiguous delete mapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteAll(@RequestBody List<Product> products) {
		service.deleteAll(products);
	}

}
