package com.inmobiliaria.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.model.Characteristics;

@Repository
public class CharacteristicsRepository implements ICharacteristicsRepository {

	//Inyectamos el JDBD para poder realizar las consultas a la BBDD
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Characteristics> findAll() {

		//Introducimos la consulta
		String SQL = "SELECT * FROM characteristics";
		//Y el retorno, que devolverá un mapeo de la clase Location (que tiene los valores de nuestra tabla)
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Characteristics.class));
	}

	@Override
	public int save(Characteristics characteristic) {

		//El INSERT devuelve los valores de la tabla locations
		String SQL = "INSERT INTO characteristics (name, grouped_in) VALUES(?,?)";
		return jdbcTemplate.update(SQL, new Object[] {characteristic.getName(), characteristic.getGrouped_in()});
	}

	@Override
	public int update(Characteristics characteristic) {

		//El UPDATE es lo mismo que el INSERT, pero filtrando con el WHERE id
		String SQL = "UPDATE characteristics SET name =?, grouped_in =? WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {characteristic.getName(),characteristic.getGrouped_in(), characteristic.getId()});
	}

	@Override
	public int deleteById(int id) {

		//El DELETE podría ser un update, si tuviera un atributo para esconderlo. En mi caso, por ahora, será un delete from
		String SQL = "DELETE FROM characteristics WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}

}
