package com.techelevator.dao;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.model.Favorites;

public class FavoritesSqlDaoIntegrationTest extends DAOIntegrationTest{
private FavoritesDAO dao;

	
	@Before
	public void setup() {
		DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new FavoritesSqlDAO(jdbcTemplate);
	}
	
	@Test
	public void getAll() {
		List<Favorites> faves = dao.getAllByUserId(1);
		Assert.assertNotNull(faves);
	}
	
	@Test
	public void newFavorite() {
		List<Favorites> favesBefore = dao.getAllByUserId(1);
		Favorites fave = new Favorites(1,120,"Test","test_img",true);
		dao.addFavorite(fave);
		List<Favorites> favesAfter = dao.getAllByUserId(1);
		Assert.assertTrue((favesBefore.size() +1) == favesAfter.size());
	
	}
	
	@Test
	public void seeIfExists() {
		Favorites fave = new Favorites(1,120,"Test","test_img",true);
		dao.addFavorite(fave);
		
		boolean doesExist = dao.exists(fave);
		Assert.assertTrue(doesExist);
	}
	
	@Test
	public void deleteFavorite() {
		Favorites fave = new Favorites(1,120,"Test","test_img",true);
		dao.addFavorite(fave);
		
		dao.delete(1,fave);
		
		Assert.assertFalse(dao.exists(fave));
	}
	@Test
	public void changeVisitedStatus() {
		Favorites fave = new Favorites(1,120,"Test","test_img",false);
		dao.addFavorite(fave);
		
		Favorites fav = new Favorites(1,120,"Test");
		dao.updateFavorite(fav);
				
		Assert.assertEquals(false,fav.isWasVisited());
		
		
	}
}
