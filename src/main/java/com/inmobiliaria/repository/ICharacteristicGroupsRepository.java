package com.inmobiliaria.repository;

import java.util.List;
import com.inmobiliaria.model.CharacteristicGroups;

public interface ICharacteristicGroupsRepository {

	public List<CharacteristicGroups> findAll();
	public int save (CharacteristicGroups group);
	public int update (CharacteristicGroups group);
	public int deleteById (int id);
}