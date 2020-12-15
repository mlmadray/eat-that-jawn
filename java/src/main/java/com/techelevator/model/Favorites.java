package com.techelevator.model;

public class Favorites {
	
	private int userId;
	private int restaurantId;
	private String restaurantName;
	
	public Favorites() {}
	
	public Favorites(int userId, int restaurantId, String restaurantName) {
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

}
