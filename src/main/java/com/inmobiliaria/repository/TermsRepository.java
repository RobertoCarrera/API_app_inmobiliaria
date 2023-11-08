package com.inmobiliaria.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.model.Terms;

@Repository
public class TermsRepository implements ITermsRepository {

	//Inyectamos el JDBD para poder realizar las consultas a la BBDD
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Terms> findAll() {

		//Introducimos la consulta
		String SQL = "SELECT * FROM terms";
		//Y el retorno, que devolverá un mapeo de la clase Location (que tiene los valores de nuestra tabla)
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Terms.class));
	}

	@Override
	public int save(Terms term) {

		//El INSERT devuelve los valores de la tabla locations
		String SQL = "INSERT INTO terms (name) VALUES(?)";
		return jdbcTemplate.update(SQL, new Object[] {term.getName()});
	}

	@Override
	public int update(Terms term) {

		//El UPDATE es lo mismo que el INSERT, pero filtrando con el WHERE id
		String SQL = "UPDATE terms SET name =? WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {term.getName(), term.getId()});
	}

	@Override
	public int deleteById(int id) {

		//El DELETE podría ser un update, si tuviera un atributo para esconderlo. En mi caso, por ahora, será un delete from
		String SQL = "DELETE FROM terms WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}

}
