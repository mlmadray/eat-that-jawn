package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Visited;

public interface VisitedDAO {
	public List<Visited> getAllByUserId(int userId);
	public void addFavorite(Visited visit);
	public void delete(int userId, int restaurantId);
	
}
