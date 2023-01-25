package com.skillstorm.project3.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project3.models.Aircraft;
import com.skillstorm.project3.services.AircraftService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Controller
@RequestMapping("/aircraft")
@Tag(name = "Aircraft API", description = "A place to manage the aircrafts that exist")
@CrossOrigin(origins = "*") 
public class AircraftController {

	
Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired // this gets created for us
	private AircraftService service; // this is property dependency injection (rather than constructor dependency injection)

	@GetMapping // convenience annotation that lets us avoid passing a bunch of parameters
	//@Operation(summary = "some summary here", description = "some description here")
	public @ResponseBody Iterable<Aircraft> findAll() {
		log.debug("Inside findAll");
		
		return service.findAll();
	}
	
	// I will define a more specific path for this GET
	@GetMapping("/{id}") // { } tells Spring Boot this endpoint has a path parameter we want to parse
	public @ResponseBody Aircraft findById(@PathVariable int id) { // if variable name does not match, specify it @PathVariable(name = "id")
		
		System.out.println("Inside findById");
		return service.findById(id);
	}
	
//	@RequestMapping(value = "/aircraft", method = RequestMethod.POST)
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Aircraft save(@RequestBody Aircraft aircraft) {
		System.out.println("Inside controller save " + aircraft);
		Aircraft aircraftCreated = service.save(aircraft);
		System.out.println("Inside controller save " + aircraftCreated);
		return aircraftCreated;
	}
	
//	@RequestMapping(value = "/aircraft", method = RequestMethod.PUT)
	@PutMapping("/{id}")
	public @ResponseBody Aircraft update(@RequestBody Aircraft aircraft, @PathVariable int id) {
		System.out.println("Inside update");
		aircraft.setItem_id(id); // probably better to do this in the Service layer, controller should just forward everything to the service
		return service.update(aircraft); // TODO if returns null update the status code to not 200 OK
	}
	
//	@RequestMapping(value = "/aircraft", method = RequestMethod.DELETE)
	@DeleteMapping("/{id}") // TODO 
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody void deleteById(@PathVariable("id") int id) {
		// Trying changing the return type to ResponseEntity<> with manually setting the response entity status code
		System.out.println("Inside deleteById");
		service.deleteById(id);
	}
	
//	@RequestMapping(value = "/aircraft", method = RequestMethod.DELETE)
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody void delete(@RequestBody Aircraft aircraft) {
		System.out.println("Inside delete");
		service.delete(aircraft);
	}

}
