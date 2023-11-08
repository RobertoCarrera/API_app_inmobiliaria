package com.inmobiliaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmobiliaria.model.Characteristics;
import com.inmobiliaria.repository.ICharacteristicsRepository;

@Service
public class CharacteristicsService implements ICharacteristicsService {

	@Autowired
	private ICharacteristicsRepository iCharacteristicsRepository;
	
	@Override
	public List<Characteristics> findAll() {

		//Definimos la devolución que queremos del método
		List<Characteristics> characteristics;
		
		try {
			
			characteristics = iCharacteristicsRepository.findAll();
		}catch(Exception ex) {
			
			throw ex;
		}
		return characteristics;
	}

	@Override
	public int save(Characteristics characteristic) {

		int new_characteristic;
		
		try {
			
			new_characteristic = iCharacteristicsRepository.save(characteristic);
		}catch(Exception ex) {
			
			throw ex;
		}
		return new_characteristic;
	}

	@Override
	public int update(Characteristics characteristic) {

		int update_characteristic;
		
		try {
			
			update_characteristic = iCharacteristicsRepository.update(characteristic);		
		}catch(Exception ex) {
			
			throw ex;
		}
		return update_characteristic;
	}

	@Override
	public int deleteById(int id) {

		int deleted_characteristic;
		
		try {
			
			deleted_characteristic = iCharacteristicsRepository.deleteById(id);
		}catch(Exception ex) {
			
			throw ex;
		}
		return deleted_characteristic;
	}

}
