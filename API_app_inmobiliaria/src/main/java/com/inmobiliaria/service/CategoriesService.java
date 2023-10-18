package com.inmobiliaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmobiliaria.model.Categories;
import com.inmobiliaria.repository.ICategoriesRepository;

@Service
public class CategoriesService implements ICategoriesService {

	@Autowired
	private ICategoriesRepository iCategoriesRepository;
	
	@Override
	public List<Categories> findAll() {

		//Definimos la devolución que queremos del método
		List<Categories> categories;
		
		try {
			
			categories = iCategoriesRepository.findAll();
		}catch(Exception ex) {
			
			throw ex;
		}
		return categories;
	}

	@Override
	public int save(Categories category) {

		int new_category;
		
		try {
			
			new_category = iCategoriesRepository.save(category);
		}catch(Exception ex) {
			
			throw ex;
		}
		return new_category;
	}

	@Override
	public int update(Categories category) {

		int update_category;
		
		try {
			
			update_category = iCategoriesRepository.update(category);		
		}catch(Exception ex) {
			
			throw ex;
		}
		return update_category;
	}

	@Override
	public int deleteById(int id) {

		int deleted_category;
		
		try {
			
			deleted_category = iCategoriesRepository.deleteById(id);
		}catch(Exception ex) {
			
			throw ex;
		}
		return deleted_category;
	}

}
