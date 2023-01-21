package com.skillstorm.project3.services;

import java.lang.Iterable;



import com.skillstorm.project3.models.Inventory;


public interface InventoryService {


	Iterable<Inventory> findAll();
	Inventory findById(int id);
	Inventory save(Inventory aircraft);
	Inventory update(Inventory aircraft);
	void delete(Inventory aircraft);
	void deleteById(int id);
	

}
