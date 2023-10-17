package com.inmobiliaria.repository;

import java.util.List;
import com.inmobiliaria.model.Properties;

public interface IPropertiesRepository {

	public List<Properties> findAll();
	public int save (Properties property);
	public int update (Properties property);
	public int deleteById (int id);
}