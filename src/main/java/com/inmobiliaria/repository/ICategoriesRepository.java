package com.inmobiliaria.repository;

import java.util.List;
import com.inmobiliaria.model.Categories;

public interface ICategoriesRepository {

	public List<Categories> findAll();
	public int save (Categories category);
	public int update (Categories category);
	public int deleteById (int id);
}
