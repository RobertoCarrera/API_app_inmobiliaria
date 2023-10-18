package com.inmobiliaria.service;

import java.util.List;
import com.inmobiliaria.model.Characteristics;

public interface ICharacteristicsService {

	public List<Characteristics> findAll();
	public int save (Characteristics characteristic);
	public int update (Characteristics characteristic);
	public int deleteById (int id);
}