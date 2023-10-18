package com.inmobiliaria.repository;

import java.util.List;
import com.inmobiliaria.model.PropertiesImages;

public interface IPropertiesImagesRepository {

	public List<PropertiesImages> findAll();
	public int save (PropertiesImages property_image);
	public int update (PropertiesImages property_image);
	public int deleteById (int id);
}
