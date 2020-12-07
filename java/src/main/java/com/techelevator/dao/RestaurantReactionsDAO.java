package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Restaurant;

public interface RestaurantReactionsDAO {
	
	public List<Restaurant> getAllLiked(int user_id);
	
	void addLikedRestaurant (Restaurant res);
	
	void updateRestaurantStatus (Restaurant res);
	// in method do isLiked = !isLiked; 
}
