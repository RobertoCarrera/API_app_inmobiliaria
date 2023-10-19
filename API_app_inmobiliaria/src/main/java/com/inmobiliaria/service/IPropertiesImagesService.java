package com.inmobiliaria.service;

import java.util.List;
import com.inmobiliaria.model.PropertiesImages;

public interface IPropertiesImagesService {

	public List<PropertiesImages> findAll();
	public int save (PropertiesImages property_image);
	public int update (PropertiesImages property_image);
	public int deleteById (int id);
}
