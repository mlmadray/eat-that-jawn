package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Favorites;

public interface FavoritesDAO {
	
	public List<Favorites> getAllByUserId(int userId);
	public void addFavorite(Favorites fave);

}
