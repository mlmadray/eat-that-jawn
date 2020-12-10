package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Favorites;

public class FavoritesSqlDAO implements FavoritesDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public FavoritesSqlDAO (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Favorites> getAllByUserId(int userId) {
		List<Favorites> faves = new ArrayList<Favorites>();
		String sql = "SELECT user_id, restaurant_id, restaurant_name FROM favorites " +
					"WHERE user_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		while (results.next()) {
			Favorites fave = mapRowToFavorites(results);
			faves.add(fave);
		}
		return faves;
	}

	@Override
	public void addFavorite(Favorites fave) {
		String sql = "INSERT INTO favorites (user_id, restaurant_id, restaurant_name) " +
					"VALUES (?, ?, ?);";
		jdbcTemplate.update(sql, fave.getUserId(), fave.getRestaurantId(), fave.getRestaurantName());
	}
	
	private Favorites mapRowToFavorites(SqlRowSet result) {
		Favorites fave = new Favorites();
		fave.setUserId(result.getInt("user_id"));
		fave.setRestaurantId(result.getInt("restaurant_id"));
		fave.setRestaurantName(result.getString("restaurant_name"));
		return  fave;
	}

}
