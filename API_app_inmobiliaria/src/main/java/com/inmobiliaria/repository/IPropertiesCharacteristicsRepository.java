package com.inmobiliaria.repository;

import java.util.List;
import com.inmobiliaria.model.PropertiesCharacteristics;

public interface IPropertiesCharacteristicsRepository {

	public List<PropertiesCharacteristics> findAll();
	public int save (PropertiesCharacteristics property_characteristic);
	public int update (PropertiesCharacteristics property_characteristic);
	public int deleteById (int id);
}
