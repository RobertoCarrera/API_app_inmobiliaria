package com.inmobiliaria.service;

import java.util.List;
import com.inmobiliaria.model.CharacteristicGroups;

public interface ICharacteristicGroupsService {

	public List<CharacteristicGroups> findAll();
	public int save (CharacteristicGroups group);
	public int update (CharacteristicGroups group);
	public int deleteById (int id);
}
