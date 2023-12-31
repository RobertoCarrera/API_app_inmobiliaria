package com.inmobiliaria.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.model.Locations;

@Repository
public class LocationsRepository implements ILocationsRepository{

	//Inyectamos el JDBD para poder realizar las consultas a la BBDD
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Locations> findAll() {

		//Introducimos la consulta
		String SQL = "SELECT * FROM locations";
		//Y el retorno, que devolverá un mapeo de la clase Location (que tiene los valores de nuestra tabla)
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Locations.class));
	}

	@Override
	public int save(Locations location) {
		
		//El INSERT devuelve los valores de la tabla locations
		String SQL = "INSERT INTO locations (name) VALUES(?)";
		return jdbcTemplate.update(SQL, new Object[] {location.getName()});
	}

	@Override
	public int update(Locations location) {
		
		//El UPDATE es lo mismo que el INSERT, pero filtrando con el WHERE id
		String SQL = "UPDATE locations SET name =? WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {location.getName(), location.getId()});
	}

	@Override
	public int deleteById(int id) {

		//El DELETE podría ser un update, si tuviera un atributo para esconderlo. En mi caso, por ahora, será un delete from
		String SQL = "DELETE FROM locations WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}

}
