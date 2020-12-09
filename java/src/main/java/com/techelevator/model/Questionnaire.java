package com.techelevator.model;

public class Questionnaire {
	
	
	private String neighborhood;
	private String category;
	private String cuisine;
	private String serviceOption;
	private int user_id;
	
	

	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getServiceOption() {
		return serviceOption;
	}
	public void setServiceOption(String serviceOption) {
		this.serviceOption = serviceOption;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getUserId() {
		return user_id;
	}
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

}
