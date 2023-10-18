package com.inmobiliaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmobiliaria.model.Locations;
import com.inmobiliaria.repository.ILocationsRepository;

@Service
public class LocationsService implements ILocationsService{

	@Autowired
	private ILocationsRepository iLocationsRepository;
	
	@Override
	public List<Locations> findAll() {
		//Definimos la devolución que queremos del método
		List<Locations> locations;
		
		try {
			
			locations = iLocationsRepository.findAll();
		}catch(Exception ex) {
			
			throw ex;
		}
		return locations;
	}

	@Override
	public int save(Locations location) {

		int new_location;
		
		try {
			
			new_location = iLocationsRepository.save(location);
		}catch(Exception ex) {
			
			throw ex;
		}
		return new_location;
	}

	@Override
	public int update(Locations location) {

		int update_location;
		
		try {
			
			update_location = iLocationsRepository.update(location);		
		}catch(Exception ex) {
			
			throw ex;
		}
		return update_location;
	}

	@Override
	public int deleteById(int id) {

		int deleted_location;
		
		try {
			
			deleted_location = iLocationsRepository.deleteById(id);
		}catch(Exception ex) {
			
			throw ex;
		}
		return deleted_location;
	}

}
