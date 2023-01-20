package com.skillstorm.project3.services;

import java.util.List;

import com.skillstorm.project3.models.Aircraft;
import com.skillstorm.project3.models.CustomException;
import com.skillstorm.project3.models.Inventory;

public interface InventoryService {


	Iterable<Inventory> findAll();
	Inventory findById(int id) throws CustomException;

	Iterable<Inventory> findByName(String name);

	Inventory save(Inventory product) throws CustomException;

	Inventory update(Inventory product, int id) throws CustomException;

	void delete(Inventory product);

	void deleteById(int id);

	void deleteAll(List<Inventory> inventory);

	Iterable<Aircraft> findAircraftByInventoryId(int id);

	Iterable<Inventory> findByDescriptionContaining(String name);

}
