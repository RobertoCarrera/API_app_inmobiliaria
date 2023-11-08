package com.inmobiliaria.service;

import java.util.List;
import com.inmobiliaria.model.PropertiesCharacteristics;

public interface IPropertiesCharacteristicsService {

	public List<PropertiesCharacteristics> findAll();
	public int save (PropertiesCharacteristics property_characteristic);
	public int update (PropertiesCharacteristics property_characteristic);
	public int deleteById (int id);
}
