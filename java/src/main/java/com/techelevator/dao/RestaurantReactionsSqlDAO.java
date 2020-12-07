package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.controller.WebService;
import com.techelevator.model.Restaurant;

@Service
public class RestaurantReactionsSqlDAO implements RestaurantReactionsDAO {
	private JdbcTemplate jdbcTemplate;
	private WebService webService;
	
	
	public RestaurantReactionsSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Restaurant> getAllLiked(int user_id) {
		List<Restaurant> resList = new ArrayList<>(); 
		String sql = "SELECT restaurant_name FROM liked_restaurants lr JOIN user_reaction ur " +
					" ON ur.liked_id = lr.id WHERE ur.user_id = ? AND lr.isLiked = true;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user_id);
		while(results.next()) {
			Restaurant restaurant = mapRowToRestaurant(results);
			resList.add(restaurant);
		}
		return resList;
	}

	@Override
	public void addLikedRestaurant(Restaurant res) {
		jdbcTemplate.update("INSERT INTO liked_restaurants (isLiked, restaurant_name)" +
							" VALUES (?,?);", res.isLiked(), res.getName());
		
	}

	@Override
	public void updateRestaurantStatus(Restaurant res) {
		jdbcTemplate.update("UPDATE liked_restaurants SET isLiked = NOT isLiked WHERE restaurant_name = ?;", res.getName());
	}
	
	private Restaurant mapRowToRestaurant(SqlRowSet rs) {
		Restaurant restaraunt = new Restaurant();
		for(Restaurant res: webService.getAllRestaurants()) {
			if(rs.getString("restaruant_name").equals(res)) {
				restaraunt = res;
			}
		}
		return restaraunt;
		/*
		Restaurant restaraunt = new Restaurant();
		restaraunt.setLiked(rs.getBoolean("isLiked"));
		restaraunt.setName("restaraunt_name");
		return restaraunt;
		*/
	}

}
