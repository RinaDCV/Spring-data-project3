package com.skillstorm.project3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Iterable;
import java.util.Optional;

import com.skillstorm.project3.models.Aircraft;
import com.skillstorm.project3.repositories.AircraftRepository;

@Service
public class AircraftServiceImpl implements AircraftService{

		
		@Autowired
		private AircraftRepository repository;

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
		public Aircraft save(Aircraft aircraft) { 
		
			if (!repository.existsById(aircraft.getId())) {
				System.out.println("Inside service save " + aircraft);
				Aircraft createdAircraft =  repository.save(aircraft);
				System.out.println("Created aircraft " + createdAircraft);
				return createdAircraft;
			}
			return aircraft;
		}

		// This method will be only slightly different
		// If the given id doesn't exist, don't do anything
		@Override
		public Aircraft update(Aircraft aircraft) {
			if (repository.existsById(aircraft.getId())) {
				return repository.save(aircraft); 
			}                                 
			return null; 
		}
		
		@Override
		public void deleteById(int id) {
			if (repository.existsById(id))
				repository.deleteById(id); 
		}

		@Override
		public void delete(Aircraft aircraft) {
			repository.delete(aircraft);
		}

	}