package com.inmobiliaria.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.model.Properties;

@Repository
public class PropertiesRepository implements IPropertiesRepository {

	//Inyectamos el JDBD para poder realizar las consultas a la BBDD
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Properties> findAll() {

		//Introducimos la consulta
		String SQL = "SELECT * FROM properties";
		//Y el retorno, que devolverá un mapeo de la clase Location (que tiene los valores de nuestra tabla)
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Properties.class));
	}

	@Override
	public int save(Properties property) {

		//El INSERT devuelve los valores de la tabla locations
		String SQL = "INSERT INTO properties (reference, price, bathrooms, bedrooms, meters, term, property_owner, location, category) VALUES(?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(SQL, new Object[] {property.getReference(),property.getPrice(),
				property.getBathrooms(),property.getBedrooms(),property.getMeters(),
				property.getTerm(),property.getProperty_owner(),property.getLocation(),property.getCategory()});
	}

	@Override
	public int update(Properties property) {

		//El UPDATE es lo mismo que el INSERT, pero filtrando con el WHERE id
		String SQL = "UPDATE properties SET reference =?, price =?, bathrooms =?, "
				+ "bedrooms =?, meters =?, term =?, property_owner =?,"
				+ "location =?, category =?  WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {property.getReference(), property.getPrice(),
				property.getBathrooms(), property.getBedrooms(), property.getMeters(), property.getTerm(),
				property.getProperty_owner(), property.getLocation(), property.getCategory(), property.getId()});
	}

	@Override
	public int deleteById(int id) {

		//El DELETE podría ser un update, si tuviera un atributo para esconderlo. En mi caso, por ahora, será un delete from
		String SQL = "DELETE FROM properties WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}

}
