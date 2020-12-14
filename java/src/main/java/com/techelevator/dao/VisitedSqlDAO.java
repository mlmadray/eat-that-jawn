package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Visited;

@Service
public class VisitedSqlDAO implements VisitedDAO {
	private JdbcTemplate jdbcTemplate;
	
	public VisitedSqlDAO (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Visited> getAllByUserId(int userId) {
		List<Visited> visit = new ArrayList<Visited>();
		String sql = "SELECT user_id, restaurant_id, restaurant_name FROM favorites " +
					"WHERE user_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		while (results.next()) {
			Visited v = mapRowToVisited(results);
			visit.add(v);
		}
		return visit;
	}

	@Override
	public void addFavorite(Visited visit) {
		String sql = "INSERT INTO visited (user_id, restaurant_id, restaurant_name)" + 
				" VALUES (?, ?, ?);";
		jdbcTemplate.update(sql, visit.getUserId(), visit.getRestaurantId(), visit.getRestaurantName());
	}
	
	@Override
	public void delete(int userId, int restaurantId) {
		String sql = "Delete FROM visited WHERE user_id =? AND restaurant_id = ?;";
		jdbcTemplate.update(sql, userId, restaurantId);
		
	}
	
	private Visited mapRowToVisited(SqlRowSet result) {
		Visited visit = new Visited();
		visit.setUserId(result.getInt("user_id"));
		visit.setRestaurantId(result.getInt("restaurant_id"));
		visit.setRestaurantName(result.getString("restaurant_name"));
		return  visit;
	}

	

}
