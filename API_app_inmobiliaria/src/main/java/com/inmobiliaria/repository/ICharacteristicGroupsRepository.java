package com.inmobiliaria.repository;

import java.util.List;
import com.inmobiliaria.model.Characteristic_groups;

public interface ICharacteristicGroupsRepository {

	public List<Characteristic_groups> findAll();
	public int save (Characteristic_groups group);
	public int update (Characteristic_groups group);
	public int deleteById (int id);
}