package com.inmobiliaria.repository;

import java.util.List;
import com.inmobiliaria.model.Owners;

public interface IOwnersRepository {

	public List<Owners> findAll();
	public int save (Owners owner);
	public int update (Owners owner);
	public int deleteById (int id);
}