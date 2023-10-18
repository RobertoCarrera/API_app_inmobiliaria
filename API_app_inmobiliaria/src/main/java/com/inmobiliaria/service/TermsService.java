package com.inmobiliaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmobiliaria.model.Terms;
import com.inmobiliaria.repository.ITermsRepository;

@Service
public class TermsService implements ITermsService {

	@Autowired
	private ITermsRepository iTermsRepository;
	
	@Override
	public List<Terms> findAll() {

		//Definimos la devolución que queremos del método
		List<Terms> terms;
		
		try {
			
			terms = iTermsRepository.findAll();
		}catch(Exception ex) {
			
			throw ex;
		}
		return terms;
	}

	@Override
	public int save(Terms term) {

		int new_term;
		
		try {
			
			new_term = iTermsRepository.save(term);
		}catch(Exception ex) {
			
			throw ex;
		}
		return new_term;
	}

	@Override
	public int update(Terms term) {

		int update_term;
		
		try {
			
			update_term = iTermsRepository.update(term);		
		}catch(Exception ex) {
			
			throw ex;
		}
		return update_term;
	}

	@Override
	public int deleteById(int id) {

		int deleted_term;
		
		try {
			
			deleted_term = iTermsRepository.deleteById(id);
		}catch(Exception ex) {
			
			throw ex;
		}
		return deleted_term;
	}

}
