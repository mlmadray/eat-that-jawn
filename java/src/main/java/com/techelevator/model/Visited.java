package com.techelevator.model;

public class Visited {
	private int userId;
	private int restaurantId;
	private String restaurantName;
	
	public Visited() {}
	
	public Visited(int userId, int restaurantId, String restuarantName) {
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.restaurantName = restuarantName;
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

