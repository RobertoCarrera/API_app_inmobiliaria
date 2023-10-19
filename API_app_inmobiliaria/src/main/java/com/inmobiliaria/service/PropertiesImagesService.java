package com.inmobiliaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.inmobiliaria.model.PropertiesImages;
import com.inmobiliaria.repository.IPropertiesImagesRepository;

public class PropertiesImagesService implements IPropertiesImagesService {

	@Autowired
	private IPropertiesImagesRepository iPropertiesImagesRepository;
	
	@Override
	public List<PropertiesImages> findAll() {

		//Definimos la devolución que queremos del método
		List<PropertiesImages> properties_images;
		
		try {
			
			properties_images = iPropertiesImagesRepository.findAll();
		}catch(Exception ex) {
			
			throw ex;
		}
		return properties_images;
	}

	@Override
	public int save(PropertiesImages property_image) {

		int new_property_image;
		
		try {
			
			new_property_image = iPropertiesImagesRepository.save(property_image);
		}catch(Exception ex) {
			
			throw ex;
		}
		return new_property_image;
	}

	@Override
	public int update(PropertiesImages property_image) {

		int update_property_image;
		
		try {
			
			update_property_image = iPropertiesImagesRepository.update(property_image);		
		}catch(Exception ex) {
			
			throw ex;
		}
		return update_property_image;
	}

	@Override
	public int deleteById(int id) {

		int deleted_property_image;
		
		try {
			
			deleted_property_image = iPropertiesImagesRepository.deleteById(id);
		}catch(Exception ex) {
			
			throw ex;
		}
		return deleted_property_image;
	}

}
