package com.techelevator.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PreferenceDAO;
import com.techelevator.dao.RestaurantReactionsDAO;
import com.techelevator.dao.UserDAO;

@RestController
@CrossOrigin
public class DatabaseController {
	private UserDAO userDAO;
	private PreferenceDAO prefDAO;
	private RestaurantReactionsDAO restReactDAO;
	
	public DatabaseController(UserDAO userDAO, PreferenceDAO prefDAO, RestaurantReactionsDAO restReactDAO) {
		this.prefDAO = prefDAO;
		this.restReactDAO = restReactDAO;
		this.userDAO = userDAO;
	}
	
	//TODO: POST new questionnaire (PreferencesDAO)
	
	//TODO: PUT update questionnaire (PreferencesDAO)
	
	//TODO: GET questionnaire answers (PreferencesDAO)
	

}
