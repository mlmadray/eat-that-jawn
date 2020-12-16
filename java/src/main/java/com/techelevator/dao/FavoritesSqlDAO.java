package com.techelevator.dao;

import java.util.ArrayList;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Favorites;

@Service
public class FavoritesSqlDAO implements FavoritesDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public FavoritesSqlDAO (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Favorites> getAllByUserId(int userId) {
		List<Favorites> faves = new ArrayList<Favorites>();
		String sql = "SELECT user_id, restaurant_id, restaurant_name, featured_image, wasvisited FROM favorites " +
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
		if(!exists(fave)) {
		String sql = "INSERT INTO favorites (user_id, restaurant_id, restaurant_name, featured_image)" + 
						" VALUES (?, ?, ?, ?);";
		jdbcTemplate.update(sql, fave.getUserId(), fave.getRestaurantId(), fave.getRestaurantName(), fave.getFeaturedImage());
		}
	}
	
	@Override
	public void updateFavorite(Favorites fav) {
		String sql = "UPDATE favorites SET wasvisited = NOT wasvisited WHERE user_id = ? AND restaurant_id = ?;";
		jdbcTemplate.update(sql, fav.getUserId(), fav.getRestaurantId());
		
	}
	
	@Override
	public void delete(int userId, Favorites fav) {
		String sql = "Delete FROM favorites WHERE user_id =? AND restaurant_id = ?;";
		jdbcTemplate.update(sql, userId, fav.getRestaurantId());
	}
	
	@Override
	public boolean exists(Favorites fav) {
		String sql = "SELECT COUNT(*) FROM favorites " +
				"WHERE (user_id = ?) AND (restaurant_id = ?);";
		int count = jdbcTemplate.queryForObject(sql, new Object[] {fav.getUserId(), fav.getRestaurantId()}, Integer.class);
		return count > 0;
	}
	
	private Favorites mapRowToFavorites(SqlRowSet result) {
		Favorites fave = new Favorites();
		fave.setUserId(result.getInt("user_id"));
		fave.setRestaurantId(result.getInt("restaurant_id"));
		fave.setRestaurantName(result.getString("restaurant_name"));
		fave.setFeaturedImage(result.getString("featured_image"));
		fave.setWasVisited(result.getBoolean("wasvisited"));
		return  fave;
	}

	

}
