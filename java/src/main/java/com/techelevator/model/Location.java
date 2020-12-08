package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	@JsonProperty("title")
	private String address;
	@JsonProperty("city_name")
	private String city;
	@JsonProperty("city_id")
	private int zipcode;
	
	public Location(String address, String city, int zip) {
		this.address = address;
		this.city = city;
		this.zipcode = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}
