package com.inmobiliaria.service;

import java.util.List;
import com.inmobiliaria.model.Categories;

public interface ICategoriesService {

	public List<Categories> findAll();
	public int save (Categories category);
	public int update (Categories category);
	public int deleteById (int id);
}