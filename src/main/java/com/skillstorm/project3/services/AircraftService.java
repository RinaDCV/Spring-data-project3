package com.skillstorm.project3.services;

import com.skillstorm.project3.models.Aircraft;

public interface AircraftService {

	Iterable<Aircraft> findAll();
	Aircraft findById(int id);
	Aircraft save(Aircraft aircraft);
	Aircraft update(Aircraft aircraft);
	void delete(Aircraft aircraft);
	void deleteById(int id);

}
