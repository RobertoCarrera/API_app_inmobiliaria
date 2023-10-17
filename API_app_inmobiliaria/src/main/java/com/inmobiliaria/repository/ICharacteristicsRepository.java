package com.inmobiliaria.repository;

import java.util.List;
import com.inmobiliaria.model.Characteristics;

public interface ICharacteristicsRepository {

	public List<Characteristics> findAll();
	public int save (Characteristics characteristic);
	public int update (Characteristics characteristic);
	public int deleteById (int id);
}