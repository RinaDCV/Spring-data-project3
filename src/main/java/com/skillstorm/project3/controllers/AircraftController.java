package com.skillstorm.project3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
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
import com.skillstorm.project3.models.Inventory;
import com.skillstorm.project3.models.Aircraft;
import com.skillstorm.project3.services.AircraftService;



@RestController
@Controller
@RequestMapping("/aircraft")
@CrossOrigin(origins = "*") 
public class AircraftController {

	@Autowired
	AircraftService service;
	
	@GetMapping
	public Iterable<Aircraft> findAll(@RequestParam(name = "name", required = false) String name, 
									@RequestParam(name = "description", required = false) String description) {
		if (name != null)
			return service.findByName(name); // TODO handle if BOTH name and description given instead of defaulting to just name
		if (description != null)
			return service.findByDescriptionContaining(description);
		return service.findAll();
	}
	  
	@GetMapping("/{id}")
	public Aircraft findById(@PathVariable int id) throws CustomException {
		return service.findById(id);
	}
	
	@GetMapping("/{id}/shops")
	public Iterable<Inventory> findInventoryByAircraftId(@PathVariable int id) {
		return service.findInventoryByAircraftId(id);
	}
	
	
	// java.lang.IllegalStateException: Ambiguous handler methods mapped for '/products/1'
//	@GetMapping("/{name}") // this is identical path to /{id} just a diff variable name, so instead
//	@GetMapping("/name/{name}")
//	@GetMapping // instead have them /products?name=bread&type=white
//	public Iterable<Product> findByName(@RequestParam(name = "name") String name) { // Prefered solution bc we are filtering not identifying one resource
//		return service.findByName(name);
//	}
//	
	
	// 200 successful or 404 not found or 400 bad request if couldn't find it
//	@PutMapping("/{id}")
//	public ResponseEntity<Aircraft> update(@RequestBody Aircraft aircraft, @PathVariable int id) throws CustomException {
//		Aircraft result = service.update(aircraft, id);
////		if (result == null)
////			return ResponseEntity.notFound().build();
//		return ResponseEntity.ok(result);
//	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Aircraft save(@RequestBody Aircraft aircraft) throws CustomException {
		return service.save(aircraft);
		
	}
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@RequestBody Aircraft aircraft) {
		service.delete(aircraft);
	}
	
	@DeleteMapping("/{id}") 
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@DeleteMapping("/all") // not the best solution, TODO handle the ambiguous delete mapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteAll(@RequestBody List<Aircraft> inventory) {
		service.deleteAll(inventory);
	}

}