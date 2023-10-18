package com.inmobiliaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inmobiliaria.model.Images;
import com.inmobiliaria.repository.IImagesRepository;


@Service
public class ImagesService implements IImagesService {

	@Autowired
	private IImagesRepository iImagesRepository;
	
	@Override
	public List<Images> findAll() {

		//Definimos la devolución que queremos del método
		List<Images> images;
		
		try {
			
			images = iImagesRepository.findAll();
		}catch(Exception ex) {
			
			throw ex;
		}
		return images;
	}

	@Override
	public int save(Images image) {

		int new_image;
		
		try {
			
			new_image = iImagesRepository.save(image);
		}catch(Exception ex) {
			
			throw ex;
		}
		return new_image;
	}

	@Override
	public int update(Images image) {

		int update_image;
		
		try {
			
			update_image = iImagesRepository.update(image);		
		}catch(Exception ex) {
			
			throw ex;
		}
		return update_image;
	}

	@Override
	public int deleteById(int id) {

		int deleted_image;
		
		try {
			
			deleted_image = iImagesRepository.deleteById(id);
		}catch(Exception ex) {
			
			throw ex;
		}
		return deleted_image;
	}

}
