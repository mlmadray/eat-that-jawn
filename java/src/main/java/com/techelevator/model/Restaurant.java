package com.techelevator.model;

public class Restaurant {
	private boolean isLiked;
	public String id;
	private String name;
	public String url;
	public Location location;
	public String price_range;
	public String featured_image;
	public UserRating user_rating;
	public String has_online_delivery;
    public String is_delivering_now;
    public String has_table_booking;
	//private String category;
	public String all_reviews_count;
	private String cuisine;
	//public List<AllReview> all_reviews; 
	
	
	//CTOR
	public Restaurant(String name, String category, String cuisine, int zip, double rating) {
		this.name = name;
		//this.category = category;
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
