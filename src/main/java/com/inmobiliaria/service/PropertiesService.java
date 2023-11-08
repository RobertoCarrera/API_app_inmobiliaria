package com.inmobiliaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmobiliaria.model.Properties;
import com.inmobiliaria.repository.IPropertiesRepository;

@Service
public class PropertiesService implements IPropertiesService {

	@Autowired
	private IPropertiesRepository iPropertiesRepository;
	
	@Override
	public List<Properties> findAll() {

		//Definimos la devolución que queremos del método
		List<Properties> properties;
		
		try {
			
			properties = iPropertiesRepository.findAll();
		}catch(Exception ex) {
			
			throw ex;
		}
		return properties;
	}

	@Override
	public int save(Properties property) {

		int new_property;
		
		try {
			
			new_property = iPropertiesRepository.save(property);
		}catch(Exception ex) {
			
			throw ex;
		}
		return new_property;
	}

	@Override
	public int update(Properties property) {

		int update_property;
		
		try {
			
			update_property = iPropertiesRepository.update(property);		
		}catch(Exception ex) {
			
			throw ex;
		}
		return update_property;
	}

	@Override
	public int deleteById(int id) {

		int deleted_property;
		
		try {
			
			deleted_property = iPropertiesRepository.deleteById(id);
		}catch(Exception ex) {
			
			throw ex;
		}
		return deleted_property;
	}

}
