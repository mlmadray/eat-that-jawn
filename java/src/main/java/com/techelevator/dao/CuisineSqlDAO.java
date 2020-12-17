package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

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
	public List<Cuisine> getAllCuisine() {
		List<Cuisine> cuis = new ArrayList<>();
		String sql = "SELECT zomato_cuisine_id, cuisine_type FROM cuisine;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Cuisine c = mapRowToCuisine(results);
			cuis.add(c);
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
