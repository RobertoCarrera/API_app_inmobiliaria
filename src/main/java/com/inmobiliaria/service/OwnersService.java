package com.inmobiliaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmobiliaria.model.Owners;
import com.inmobiliaria.repository.IOwnersRepository;

@Service
public class OwnersService implements IOwnersService {

	@Autowired
	private IOwnersRepository iOwnersRepository;
	
	@Override
	public List<Owners> findAll() {

		//Definimos la devolución que queremos del método
		List<Owners> owners;
		
		try {
			
			owners = iOwnersRepository.findAll();
		}catch(Exception ex) {
			
			throw ex;
		}
		return owners;
	}

	@Override
	public int save(Owners owner) {

		int new_owner;
		
		try {
			
			new_owner = iOwnersRepository.save(owner);
		}catch(Exception ex) {
			
			throw ex;
		}
		return new_owner;
	}

	@Override
	public int update(Owners owner) {

		int update_owner;
		
		try {
			
			update_owner = iOwnersRepository.update(owner);		
		}catch(Exception ex) {
			
			throw ex;
		}
		return update_owner;
	}

	@Override
	public int deleteById(int id) {

		int deleted_owner;
		
		try {
			
			deleted_owner = iOwnersRepository.deleteById(id);
		}catch(Exception ex) {
			
			throw ex;
		}
		return deleted_owner;
	}

}
