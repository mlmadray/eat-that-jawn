package com.techelevator.model;

public class Questionnaire {
	
	private String firstName;
	private String city;
	private String zipcode;
	//private String category;
	private String cuisine;
	private String serviceOption;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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

}
