package com.inmobiliaria.repository;

import java.util.List;
import com.inmobiliaria.model.Terms;

public interface ITermsRepository {
	
	public List<Terms> findAll();
	public int save (Terms term);
	public int update (Terms term);
	public int deleteById (int id);
}