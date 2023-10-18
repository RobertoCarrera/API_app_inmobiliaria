package com.inmobiliaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmobiliaria.model.PropertiesCharacteristics;
import com.inmobiliaria.repository.IPropertiesCharacteristicsRepository;

@Service
public class PropertiesCharacteristicsService implements IPropertiesCharacteristicsService {

	@Autowired
	private IPropertiesCharacteristicsRepository iPropertiesCharacteristicsRepository;
	
	@Override
	public List<PropertiesCharacteristics> findAll() {

		//Definimos la devolución que queremos del método
		List<PropertiesCharacteristics> properties_characteristics;
		
		try {
			
			properties_characteristics = iPropertiesCharacteristicsRepository.findAll();
		}catch(Exception ex) {
			
			throw ex;
		}
		return properties_characteristics;
	}

	@Override
	public int save(PropertiesCharacteristics property_characteristic) {

		int new_property_characteristic;
		
		try {
			
			new_property_characteristic = iPropertiesCharacteristicsRepository.save(property_characteristic);
		}catch(Exception ex) {
			
			throw ex;
		}
		return new_property_characteristic;
	}

	@Override
	public int update(PropertiesCharacteristics property_characteristic) {

		int update_property_characteristic;
		
		try {
			
			update_property_characteristic = iPropertiesCharacteristicsRepository.update(property_characteristic);	
		}catch(Exception ex) {
			
			throw ex;
		}
		return update_property_characteristic;
	}

	@Override
	public int deleteById(int id) {

		int deleted_property_characteristic;
		
		try {
			
			deleted_property_characteristic = iPropertiesCharacteristicsRepository.deleteById(id);
		}catch(Exception ex) {
			
			throw ex;
		}
		return deleted_property_characteristic;
	}

}
