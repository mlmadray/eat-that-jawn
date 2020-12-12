package com.techelevator.dao;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.Category;


public class CategorySqlDAOIntegrationTest extends DAOIntegrationTest{
private CategoryDAO dao;
	
	@Before
	public void setup() {
		DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new CategorySqlDAO(jdbcTemplate);
	}
	
	@Test 
	public void getAll() {
		List <Category> cat = dao.getAllCategories();
		Assert.assertNotNull(cat);
	}
}
