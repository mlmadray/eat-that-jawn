package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Cuisine;

public interface CuisineDAO {
	
	//public Cuisine getSingleCuisine(String name);
	public List<Cuisine> getAllCuisine();

}
