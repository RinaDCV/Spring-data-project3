package com.skillstorm.project3.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.project3.models.Inventory;

@Repository

public interface InventoryRepository extends CrudRepository <Inventory, Integer>{
	


}