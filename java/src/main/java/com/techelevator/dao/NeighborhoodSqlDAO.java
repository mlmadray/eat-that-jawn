package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Neighborhood;

@Service
public class NeighborhoodSqlDAO implements NeighborhoodDAO {

private JdbcTemplate jdbcTemplate;
	
	public NeighborhoodSqlDAO (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Neighborhood> getAllNeighborhoods() {
		List<Neighborhood> neighborhoods = new ArrayList<Neighborhood>();
		String sql = "SELECT locality_subzone_id, locality_subzone_name FROM neighborhoods;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Neighborhood neigh = mapRowToNeighborhood(results);
			neighborhoods.add(neigh);
		}
		return neighborhoods;
	}
	
	private Neighborhood mapRowToNeighborhood(SqlRowSet result) {
		Neighborhood neighborhood = new Neighborhood();
		neighborhood.setLocalitySubzoneId(result.getInt("locality_subzone_id"));
		neighborhood.setLocalitySubzoneName(result.getString("locality_subzone_name"));
		return  neighborhood;
	}

}
