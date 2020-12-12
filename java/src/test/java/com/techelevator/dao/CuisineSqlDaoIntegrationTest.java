package com.techelevator.dao;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.Cuisine;

public class CuisineSqlDaoIntegrationTest extends DAOIntegrationTest {
	private CuisineDAO dao;
	
	@Before
	public void setup() {
		DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new CuisineSqlDAO(jdbcTemplate);
	}
	
	@Test 
	public void getAll() {
		List <Cuisine> cuis = dao.getAllCuisine();
		Assert.assertNotNull(cuis);
	}
	
}
