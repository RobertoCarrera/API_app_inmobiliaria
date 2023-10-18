package com.inmobiliaria.repository;

import java.util.List;
import com.inmobiliaria.model.Images;

public interface IImagesRepository {

	public List<Images> findAll();
	public int save (Images image);
	public int update (Images image);
	public int deleteById (int id);
}
