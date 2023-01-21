package com.skillstorm.project3.services;


import java.util.List;

import com.skillstorm.project3.models.Aircraft;
import com.skillstorm.project3.models.CustomException;
import com.skillstorm.project3.models.Inventory;

public interface AircraftService {

	Iterable<Aircraft> findAll();

	Aircraft findById(int id) throws CustomException;
	
	Iterable<Aircraft> findByName(String name);
	
	Aircraft save(Aircraft aircraft) throws CustomException;
	
	Aircraft update(Aircraft aircraft, int id) throws CustomException;
	
	void delete(Aircraft aircraft);
	
	void deleteById(int id);
	
	void deleteAll(List<Aircraft> aircraft);
	
	Iterable<Inventory> findInventoryByAircraftId(int id);
	
	Iterable<Aircraft> findByDescriptionContaining(String name);

	

	



	

}
