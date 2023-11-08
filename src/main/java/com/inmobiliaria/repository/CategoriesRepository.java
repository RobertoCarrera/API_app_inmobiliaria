package com.inmobiliaria.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.model.Categories;

@Repository
public class CategoriesRepository implements ICategoriesRepository {

	//Inyectamos el JDBD para poder realizar las consultas a la BBDD
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Categories> findAll() {

		//Introducimos la consulta
		String SQL = "SELECT * FROM categories";
		//Y el retorno, que devolverá un mapeo de la clase Location (que tiene los valores de nuestra tabla)
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Categories.class));
	}

	@Override
	public int save(Categories category) {

		//El INSERT devuelve los valores de la tabla locations
		String SQL = "INSERT INTO categories (name) VALUES(?)";
		return jdbcTemplate.update(SQL, new Object[] {category.getName()});
	}

	@Override
	public int update(Categories category) {

		//El UPDATE es lo mismo que el INSERT, pero filtrando con el WHERE id
		String SQL = "UPDATE categories SET name =? WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {category.getName(), category.getId()});
	}

	@Override
	public int deleteById(int id) {

		//El DELETE podría ser un update, si tuviera un atributo para esconderlo. En mi caso, por ahora, será un delete from
		String SQL = "DELETE FROM categories WHERE id = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}

}
