package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Category;

@Service
public class CategorySqlDAO implements CategoryDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public CategorySqlDAO (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT zomato_category_id, category_name FROM category;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Category cat = mapRowToCategory(results);
			categories.add(cat);
		}
		return categories;
	}
	
	private Category mapRowToCategory(SqlRowSet result) {
		Category category = new Category();
		category.setZomatoCategoryId(result.getInt("zomato_category_id"));
		category.setCategoryName(result.getString("category_name"));
		return category;
	}

}
