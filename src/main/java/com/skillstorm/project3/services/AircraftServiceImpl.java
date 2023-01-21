package com.skillstorm.project3.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.project3.models.Aircraft;
import com.skillstorm.project3.models.CustomException;
import com.skillstorm.project3.models.Inventory;
import com.skillstorm.project3.repositories.AircraftRepository;



@Service
public class AircraftServiceImpl implements AircraftService{

	@Autowired
	AircraftRepository repo;

	Logger log = LoggerFactory.getLogger(AircraftServiceImpl.class);

	@Override
	public Iterable<Aircraft> findAll() {
		return repo.findAll();
	}

	@Override
	public Aircraft findById(int id) throws CustomException {
		Optional<Aircraft> result =  repo.findById(id); // you could store the optional and do a ifPresent() check then .get() else return null
		if (!result.isPresent())
			throw new CustomException("No inventory exists with id of " + id + ".");
		return result.get();
	}

	@Override
	public Iterable<Aircraft> findByName(String name) {
		return repo.findByNameContaining(name);
	}

	@Override // THIS IS A CONTRIVED EXAMPLE FOR THE GLOBALEXCEPTIONHANDLER, SAVE DOES NOT NEED TO DO ANY LOGIC
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Aircraft save(Aircraft aircraft) throws CustomException {
		// if save ignores the id (you could set it to 0) then it would not be indempotent and would create a new one every time
		// save is looking at the id and will overwrite it if it already exists
		// to prevent this behavior do a check:
		log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + aircraft.toString());
		if (!repo.existsById(aircraft.getAircraft_id())) {
			return repo.save(aircraft);
		}
		throw new CustomException("A product already exists with id of " + aircraft.getAircraft_id() + ".");
	}

	@Override
	public Aircraft update(Aircraft aircraft, int id) throws CustomException {
		if (!repo.existsById(id)) {
			throw new CustomException("Update didn't work bc there is no existing record with the given id " + id +"."); // TODO make a custom exception to throw here
		} else {
			aircraft.setAircraft_id(id);
			return repo.save(aircraft);
		}
	}

	@Override
	public void delete(Aircraft aircraft) {
		repo.delete(aircraft);
	}

	@Override
	public void deleteById(int id) { // TODO we could let it throw the error and add to our GlobalExceptionHanlder class a method to create the HTTP response in this situation
		if (repo.existsById(id)) // this is to make our deletebyid more rebust (ex: if we run this twice in a row by accident)
			repo.deleteById(id); // this is throwing an error if we try to delete a nonexistent row 
	}

	@Override
	public void deleteAll(List<Aircraft> aircraft) {
		repo.deleteAll(aircraft);
	}

	@Override
	public Iterable<Inventory> findInventoryByAircraftId(int id) {
		log.debug("======================================================\n" 
					+ "HERE I AM IN AircraftServiceImpl findInventoryByAircraftId!");
		return repo.findInventoryByAircraftId(id);
	}
	
	@Override
	public Iterable<Aircraft> findByDescriptionContaining(String name) {
		return repo.findByDescriptionContaining("%" + name + "%");
	}

} 












