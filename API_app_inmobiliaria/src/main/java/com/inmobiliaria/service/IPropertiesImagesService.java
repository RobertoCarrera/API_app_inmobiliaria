package com.inmobiliaria.service;

import java.util.List;
import com.inmobiliaria.model.PropertiesImages;

public interface IPropertiesImagesService {

	public List<PropertiesImages> findAll();
	public int save (PropertiesImages properties_images);
	public int update (PropertiesImages properties_images);
	public int deleteById (int id);
}
