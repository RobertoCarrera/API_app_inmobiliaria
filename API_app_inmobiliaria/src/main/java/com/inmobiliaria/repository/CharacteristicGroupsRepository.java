package com.inmobiliaria.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.inmobiliaria.model.Characteristic_groups;

public class CharacteristicGroupsRepository implements ICharacteristicGroupsRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Characteristic_groups> findAll() {

		//Introducimos la consulta
		String SQL = "SELECT * FROM characteristic_groups";
		//Y el retorno, que devolverá un mapeo de la clase Location (que tiene los valores de nuestra tabla)
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Characteristic_groups.class));
	}

	@Override
	public int save(Characteristic_groups group) {

		//El INSERT devuelve los valores de la tabla locations
		String SQL = "INSERT INTO characteristic_groups VALUES(?)";
		return jdbcTemplate.update(SQL, new Object[] {group.getName()});
	}

	@Override
	public int update(Characteristic_groups group) {

		//El UPDATE es lo mismo que el INSERT, pero filtrando con el WHERE id
		String SQL = "UPDATE characteristic_groups SET name =? WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {group.getName()});
	}

	@Override
	public int deleteById(int id) {

		//El DELETE podría ser un update, si tuviera un atributo para esconderlo. En mi caso, por ahora, será un delete from
		String SQL = "DELETE * FROM characteristic_groups WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}

}
