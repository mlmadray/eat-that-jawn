package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Favorites;

public interface FavoritesDAO {
	
	public List<Favorites> getAllByUserId(int userId);
	public void addFavorite(Favorites fave);
	public boolean exists(Favorites fav);
	public void updateFavorite(Favorites fav);
	public void delete(int userId, Favorites fav);

}
