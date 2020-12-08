package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Restaurant {
	private boolean isLiked;
	@JsonProperty("id")
	public String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("url")
	public String url;
	@JsonProperty("location")
	public ResLocation resLocation;
	@JsonProperty("price_range")
	public String price_range;
	@JsonProperty("featured_image")
	public String featured_image;
	@JsonProperty("user_rating")
	public UserRating user_rating;
	@JsonProperty("has_online_delivery")
	public boolean has_online_delivery;
	@JsonProperty("is_delivering_now")
    public boolean is_delivering_now;
	@JsonProperty("has_table_booking")
    public boolean has_table_booking;
	//private String category;
	@JsonProperty("all_reviews_count")
	public int all_reviews_count;
	@JsonProperty("cuisine")
	private String cuisine;
	//public List<AllReview> all_reviews; 
	
	
	//CTOR
	public Restaurant(String id, String name, String url, String Location, String cuisine, int zip, double rating) {
		this.name = name;
		this.cuisine = cuisine;
		
	}
	public Restaurant(boolean isLiked, String name) {
		this.isLiked = isLiked;
		this.name = name;
	}
	
	public Restaurant() {
		
	}
	
	// GETTERS & SETTERS
	public boolean isLiked() {
		return isLiked;
	}
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	*/
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	
	
	//helper methods
	/*
	public String toString() {
		
	}
	*/
	
}
