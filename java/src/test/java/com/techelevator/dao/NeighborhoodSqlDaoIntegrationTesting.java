package com.techelevator.dao;

import java.util.List;
import org.junit.Assert;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.Neighborhood;



public class NeighborhoodSqlDaoIntegrationTesting extends DAOIntegrationTest {
	
	private NeighborhoodDAO dao;
	
	@Before
	public void setup() {
		DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new NeighborhoodSqlDAO(jdbcTemplate);
	}

	@Test
	public void getAll() {
		List<Neighborhood> list = dao.getAllNeighborhoods();
		Assert.assertNotNull(list);
	}
	
}
