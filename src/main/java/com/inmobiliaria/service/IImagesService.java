package com.inmobiliaria.service;

import java.util.List;
import com.inmobiliaria.model.Images;

public interface IImagesService {

	public List<Images> findAll();
	public int save (Images image);
	public int update (Images image);
	public int deleteById (int id);
}
