package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Locations;

public interface ILocationsService {

	public List<Locations> findAll();
	public int save (Locations location);
	public int update (Locations location);
	public int deleteById (int id);
}
