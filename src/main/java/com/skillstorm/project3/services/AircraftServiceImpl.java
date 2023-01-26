

package com.skillstorm.project3.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.project3.models.Aircraft;
import com.skillstorm.project3.repositories.AircraftRepository;


@Service
public class AircraftServiceImpl implements AircraftService{

	@Autowired
	AircraftRepository repository;



	@Override
	public Iterable<Aircraft> findAll() {
		return repository.findAll();
	}

	@Override
	public Aircraft findById(int id) {
		Optional<Aircraft> aircraft = repository.findById(id);
		return aircraft.isPresent() ? aircraft.get() : null;
	}

	
	// This method could work two ways:
	// 1. check if it exists already, if so don't overwrite it
	// 2. go ahead and save it, if it already exists it will be overwritten
	@Override
	public Aircraft save(Aircraft aircraft) { // The save implementation 
		// Method 1:
		if (!repository.existsById(aircraft.getItem_id())) {
			System.out.println("Inside service save " + aircraft);
			Aircraft createdaircraft =  repository.save(aircraft);
			System.out.println("Created aircraft " + createdaircraft);
			return createdaircraft;
		}
		return aircraft;
	}

	// This method will be only slightly different
	// If the given id doesn't exist, don't do anything
	@Override
	public Aircraft update(Aircraft aircraft) {
		if (repository.existsById(aircraft.getItem_id())) {
			return repository.save(aircraft); // I cannot change the id because I can't search by one Id and set with another id
		}                                 // Idea to implement this: delete the entry of the old idea using deleteById() and save(aircraft) with new id
		return null; 
	}
	
	@Override
	public void deleteById(int id) {
		if (repository.existsById(id))
			repository.deleteById(id); // org.springframework.dao.EmptyResultDataAccessException: No class com.skillstorm.practice.models.aircraft entity with id 3 exists!
	}

	@Override
	public void delete(Aircraft aircraft) {
		repository.delete(aircraft);
	}

}

