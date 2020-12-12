package com.techelevator.model;

public class Cuisine {
	
	private int zomatoCuisineId;
	private String cuisineType;
	
	public Cuisine() {}
	
	public Cuisine(int id, String type) {
		this.zomatoCuisineId = id;
		this.cuisineType = type;
	}
	
	public int getZomatoCuisineId() {
		return zomatoCuisineId;
	}
	public void setZomatoCuisineId(int zomatoCuisineId) {
		this.zomatoCuisineId = zomatoCuisineId;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

}
