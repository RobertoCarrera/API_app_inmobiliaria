package com.inmobiliaria.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.inmobiliaria.model.PropertiesCharacteristics;

@Repository
public class PropertiesCharacteristicsRepository implements IPropertiesCharacteristicsRepository {

	//Inyectamos el JDBD para poder realizar las consultas a la BBDD
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override

	public List<PropertiesCharacteristics> findAll() {
	//Introducimos la consulta
	String SQL = "SELECT * FROM properties_characteristics";
	//Y el retorno, que devolverá un mapeo de la clase Location (que tiene los valores de nuestra tabla)
	return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(PropertiesCharacteristics.class));
	}

	@Override
	public int save(PropertiesCharacteristics property_characteristic) {

		//El INSERT devuelve los valores de la tabla locations
		String SQL = "INSERT INTO properties_characteristics (id_property, id_characteristic) VALUES(?,?)";
		return jdbcTemplate.update(SQL, new Object[] {property_characteristic.getId_property(),property_characteristic.getId_characteristic()});
	}

	@Override
	public int update(PropertiesCharacteristics property_characteristic) {

		//El UPDATE es lo mismo que el INSERT, pero filtrando con el WHERE id
		String SQL = "UPDATE properties_characteristics SET id_property =?, id_characteristic =? WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {property_characteristic.getId_property(),property_characteristic.getId_characteristic(), property_characteristic.getId()});
	}

	@Override
	public int deleteById(int id) {

		//El DELETE podría ser un update, si tuviera un atributo para esconderlo. En mi caso, por ahora, será un delete from
		String SQL = "DELETE FROM properties_characteristics WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}

}
