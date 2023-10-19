package com.inmobiliaria.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.inmobiliaria.model.PropertiesImages;
import com.inmobiliaria.service.IPropertiesImagesService;

@Repository
public class PropertiesImagesRepository implements IPropertiesImagesService {

	//Inyectamos el JDBD para poder realizar las consultas a la BBDD
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PropertiesImages> findAll() {

		//Introducimos la consulta
		String SQL = "SELECT * FROM properties_images";
		//Y el retorno, que devolverá un mapeo de la clase Location (que tiene los valores de nuestra tabla)
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(PropertiesImages.class));
	}

	@Override
	public int save(PropertiesImages property_image) {

		//El INSERT devuelve los valores de la tabla locations
		String SQL = "INSERT INTO properties_images (id_property, id_image) VALUES(?,?)";
		return jdbcTemplate.update(SQL, new Object[] {property_image.getId_property(), property_image.getId_image()});
	}

	@Override
	public int update(PropertiesImages property_image) {

		//El UPDATE es lo mismo que el INSERT, pero filtrando con el WHERE id
		String SQL = "UPDATE properties_images SET id_property =?, id_image =? WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {property_image.getId_property(), property_image.getId_image(), property_image.getId()});
	}

	@Override
	public int deleteById(int id) {

		//El DELETE podría ser un update, si tuviera un atributo para esconderlo. En mi caso, por ahora, será un delete from
		String SQL = "DELETE FROM properties_images WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}

}
