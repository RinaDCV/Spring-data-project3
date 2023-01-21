package com.skillstorm.project3.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.skillstorm.project3.models.CustomException;
import com.skillstorm.project3.models.Product;
import com.skillstorm.project3.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Controller
@RequestMapping("/product")
@Tag(name = "Product API", description = "A place to manage the shops that exist")
@CrossOrigin(origins = "local host:4200") // later u can change to * //allows frontend and backend to communicate
public class ProductController {

	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProductService service;
	

	@GetMapping // convenience annotation that lets us avoid passing a bunch of parameters
	@Operation(summary = "some summary here", description = "some description here")
	public @ResponseBody Iterable<Product> findAll() {
		log.debug("Inside findAll");
		
		return service.findAll();
	}
	

	@GetMapping("/{id}") 
	public @ResponseBody Product findById(@PathVariable int id) throws CustomException {
		System.out.println("Inside findById");
		return service.findById(id);
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Product save(@RequestBody Product aircraft) throws CustomException {
		System.out.println("Inside controller save " + aircraft);
		Product aircraftCreated = service.save(aircraft);
		System.out.println("Inside controller save " + aircraftCreated);
		return aircraftCreated;
	}
	
	@PutMapping("/{id}")
	public @ResponseBody Product update(@RequestBody Product aircraft, @PathVariable int id) {
		System.out.println("Inside update");
		aircraft.setId(id); // probably better to do this in the Service layer, controller should just forward everything to the service
		return service.update(aircraft); 
	}
	

	@DeleteMapping("/{id}") 
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody void deleteById(@PathVariable("id") int id) {
		// Trying changing the return type to ResponseEntity<> with manually setting the response entity status code
		System.out.println("Inside deleteById");
		service.deleteById(id);
	}
	

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody void delete(@RequestBody Product aircraft) {
		System.out.println("Inside delete");
		service.delete(aircraft);
	}

}