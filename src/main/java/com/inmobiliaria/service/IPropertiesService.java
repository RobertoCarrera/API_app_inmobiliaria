package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Properties;

public interface IPropertiesService {

	public List<Properties> findAll();
	public int save (Properties property);
	public int update (Properties property);
	public int deleteById (int id);
}
