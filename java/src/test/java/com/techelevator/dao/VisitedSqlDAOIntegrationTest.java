package com.techelevator.dao;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.Visited;

public class VisitedSqlDAOIntegrationTest extends DAOIntegrationTest{
	private VisitedDAO dao;
	
		
		@Before
		public void setup() {
			DataSource dataSource = this.getDataSource();
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        dao = new VisitedSqlDAO(jdbcTemplate);
		}
		
		@Test
		public void getAll() {
			Visited v = new Visited(1,120,"Test");
			dao.addVisit(v);
			
			List<Visited> visit = dao.getAllByUserId(1);
			Assert.assertNotNull(visit);
		}
		
		@Test
		public void newFavorite() {
			List<Visited> visitBefore = dao.getAllByUserId(1);
			Visited v = new Visited(1,120,"Test");
			dao.addVisit(v);
			List<Visited> visitAfter = dao.getAllByUserId(1);
			Assert.assertFalse(visitBefore.size() < visitAfter.size());
		
		}
			
		@Test
		public void deleteFavorite() {
			Visited v = new Visited(1,120,"Test");
			dao.addVisit(v);
			
			dao.delete(1, 120);
			
			Assert.assertTrue(dao.getAllByUserId(1).size() == 0);
		}
}
