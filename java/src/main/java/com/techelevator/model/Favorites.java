package com.techelevator.model;

public class Favorites {
	
	private int userId;
	private int restaurantId;
	private String restaurantName;
	private String featuredImage;
	private boolean wasVisited;
	
	public Favorites() {}
	
	public Favorites(int userId, int restaurantId, String restaurantName) {
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
	}
	
	public Favorites(int userId, int restaurantId, String restaurantName, String featuredImage, boolean wasVisited) {
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.featuredImage = featuredImage;
		this.wasVisited = wasVisited;
	}
	
	public String getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
		this.featuredImage = featuredImage;
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

	public boolean isWasVisited() {
		return wasVisited;
	}

	public void setWasVisited(boolean wasVisited) {
		this.wasVisited = wasVisited;
	}

}
