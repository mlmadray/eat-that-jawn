package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Cuisine;

@Service
public class CuisineSqlDAO implements CuisineDAO {
	private JdbcTemplate jdbcTemplate;
	
	public CuisineSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Cuisine getSingleCuisine(String name) {
		Cuisine cuis = new Cuisine();
		String sql = "SELECT zomato_cuisine_id, cuisine_type FROM cuisine WHERE cuisine_type = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
		if(results.next()) {
			cuis = mapRowToCuisine(results);
		}
		return cuis;
	}
	
	private Cuisine mapRowToCuisine(SqlRowSet cuis) {
		Cuisine cuisine = new Cuisine();
		cuisine.setZomatoCuisineId(cuis.getInt("zomato_cuisine_id"));
		cuisine.setCuisineType(cuis.getString("cuisine_type"));
		return cuisine;
	}

}
