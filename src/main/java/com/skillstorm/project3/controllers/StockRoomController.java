//package com.skillstorm.project3.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//
//import com.skillstorm.project3.models.WhareHouse;
//import com.skillstorm.project3.services.WhareHouseService;
//
//@Controller
//@RequestMapping("/Wharehouse")
//
//public class StockRoomController {
//
//	@Autowired
//	private WhareHouseService service;
//	
//	@GetMapping
////	@RequestMapping(value="/WhareHouse", method = RequestMethod.GET)
//	public @ResponseBody Iterable<WhareHouse> findAll() {
//		System.out.println("inside findall");
//		
//		return service.findAll();
//	}
//	@PutMapping
////	@RequestMapping(value="/WhareHouse", method = RequestMethod.PUT)
//	public @ResponseBody WhareHouse update(WhareHouse wharehouse) {
//	System.out.println("inside update");
//	return service.update(wharehouse);
//	}
//	@PostMapping
////	@RequestMapping(value="/WhareHouse", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public @ResponseBody WhareHouse save(WhareHouse wharehouse) {
//	System.out.println("inside save");
//	return service.save(wharehouse);
//	}
//	@DeleteMapping
////	@RequestMapping(value="/WhareHouse", method = RequestMethod.DELETE)
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public @ResponseBody void delete(WhareHouse wharehouse) {
//	System.out.println("inside deleteById");
//	service.delete(wharehouse);
//	}
//	@GetMapping("/{id}")
//	public @ResponseBody WhareHouse findById(@PathVariable int id) {
//		System.out.println("inside findById");
//		return null;
//	}
//}
