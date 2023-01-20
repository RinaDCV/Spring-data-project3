package com.skillstorm.project3.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.project3.models.Aircraft;
import com.skillstorm.project3.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository <Inventory, Integer> {
Iterable<Inventory> findByNameContaining(String name);
	
	@Query(value = "SELECT * FROM product WHERE description LIKE ?1 ;", nativeQuery = true) // can write your own query in JPQL (different syntax than SQL we've been using)
	Iterable<Inventory> findByDescriptionContaining(String description); // must pre and append the % in the service
	
	// This is a JPQL query (Java Persistence Query Language) 
	@Query("SELECT s FROM Product p JOIN p.shops s WHERE p.id = :id") // :id is a named parameter // I could have done ?1
	Iterable<Aircraft> findAircraftByInventoryId(@Param("id") int id); // Annotate the parameter the @Param("whateveryounamedit")

}
