package com.techelevator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.techelevator.dao.QuestionnaireDAO;
import com.techelevator.dao.RestaurantReactionsDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Questionnaire;
import com.techelevator.model.Restaurant;

@RestController
@CrossOrigin
public class RestaurantController {
	private UserDAO userDAO;
	private QuestionnaireDAO prefDAO;
	private RestaurantReactionsDAO restReactDAO;
	private WebService webService;
	
	public RestaurantController(UserDAO userDAO, QuestionnaireDAO prefDAO, RestaurantReactionsDAO restReactDAO) {
		this.prefDAO = prefDAO;
		this.restReactDAO = restReactDAO;
		this.userDAO = userDAO;
	}
	
	//TODO: POST new questionnaire (PreferencesDAO)
	@RequestMapping(value = "/questionnaire/{user_id}", method = RequestMethod.POST)
	void createNewQuestionnaire(@PathVariable int user_id, @RequestBody Questionnaire ques) {
		prefDAO.createNewQuestionnaire(user_id, ques);
	}
	
	//TODO: PUT update questionnaire (PreferencesDAO)
	@RequestMapping(value = "/questionnaire/{user_id}", method = RequestMethod.PUT)
	void updateExistingQuestionnaire(@PathVariable int user_id, @RequestBody Questionnaire ques) {
		prefDAO.updateQuestionnaire(user_id, ques);
	}
	
	//TODO: GET questionnaire answers (PreferencesDAO)
	@RequestMapping(value = "/questionnaire/{user_id}", method = RequestMethod.GET)
	public Questionnaire getQuestionnnaireByUser(@PathVariable int user_id) {
		return prefDAO.getAnswers(user_id);
	}
	
	//TODO: GET liked restaurants (ReactionsDAO)
	@RequestMapping(value = "/restaurants/{user_id}", method = RequestMethod.GET)
	public List<Restaurant> getAllLikedRestaurants(@PathVariable int user_id) {
		return restReactDAO.getAllLiked(user_id);
		
	}
	
	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	public Restaurant [] getAllRestaurants() {
		return webService.getAllRestaurants();
	}
	
}
