package com.inmobiliaria.repository;

import java.util.List;
import com.inmobiliaria.model.Locations;

public interface ILocationsRepository {

	public List<Locations> findAll();
	public int save (Locations location);
	public int update (Locations location);
	public int deleteById (int id);
}