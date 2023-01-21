package com.skillstorm.project3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Iterable;
import java.util.Optional;


import com.skillstorm.project3.models.Inventory;
import com.skillstorm.project3.repositories.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryRepository repository;

	@Override
	public Iterable<Inventory> findAll() {
		return repository.findAll();
	}

	@Override 
	public Inventory findById(int id) {
		Optional<Inventory> inventory = repository.findById(id);
		return inventory.isPresent() ? inventory.get() : null;
	}


	// This method could work two ways:
	// 1. check if it exists already, if so don't overwrite it
	// 2. go ahead and save it, if it already exists it will be overwritten
	@Override
	public Inventory save(Inventory inventory) { // The save implementation 
		// Method 1:
		if (!repository.existsById(inventory.getId())) {
			System.out.println("Inside service save " + inventory);
			Inventory createdInventory =  repository.save(inventory);
			System.out.println("Created inventory " + createdInventory);
			return createdInventory;
		}
		return inventory;
	}

	// This method will be only slightly different
	// If the given id doesn't exist, don't do anything
	@Override
	public Inventory update(Inventory inventory) {
		if (repository.existsById(inventory.getId())) {
			return repository.save(inventory); 
		}                                 
		return null; 
	}

	@Override
	public void deleteById(int id) {
		if (repository.existsById(id))
			repository.deleteById(id); 
	}

	@Override
	public void delete(Inventory inventory) {
		repository.delete(inventory);
	}

}	