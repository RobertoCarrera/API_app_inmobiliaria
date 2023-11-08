package com.inmobiliaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmobiliaria.model.CharacteristicGroups;
import com.inmobiliaria.repository.ICharacteristicGroupsRepository;

@Service
public class CharacteristicGroupsService implements ICharacteristicGroupsService {

	@Autowired
	private ICharacteristicGroupsRepository iCharacteristicGroupsRepository;
	
	@Override
	public List<CharacteristicGroups> findAll() {

		//Definimos la devolución que queremos del método
		List<CharacteristicGroups> characteristic_group;
		
		try {
			
			characteristic_group = iCharacteristicGroupsRepository.findAll();
		}catch(Exception ex) {
			
			throw ex;
		}
		return characteristic_group;
	}

	@Override
	public int save(CharacteristicGroups group) {
		
		int new_group;
		
		try {
			
			new_group = iCharacteristicGroupsRepository.save(group);
		}catch(Exception ex) {
			
			throw ex;
		}
		return new_group;
	}

	@Override
	public int update(CharacteristicGroups group) {

		int update_group;
		
		try {
			
			update_group = iCharacteristicGroupsRepository.update(group);		
		}catch(Exception ex) {
			
			throw ex;
		}
		return update_group;
	}

	@Override
	public int deleteById(int id) {

		int deleted_group;
		
		try {
			
			deleted_group = iCharacteristicGroupsRepository.deleteById(id);
		}catch(Exception ex) {
			
			throw ex;
		}
		return deleted_group;
	}

}
