package com.techelevator.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techelevator.dao.CategoryDAO;
import com.techelevator.dao.CuisineDAO;
import com.techelevator.dao.NeighborhoodDAO;
import com.techelevator.dao.QuestionnaireDAO;
import com.techelevator.dao.ServiceOptionDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Category;
import com.techelevator.model.Cuisine;
import com.techelevator.model.Neighborhood;
import com.techelevator.model.Questionnaire;

@RestController
@CrossOrigin

public class RestaurantController {
	private UserDAO userDAO;
	private QuestionnaireDAO prefDAO;
	private CuisineDAO cuisineDAO;
	private NeighborhoodDAO neighborhoodDAO;
	private CategoryDAO categoryDAO;
	private ServiceOptionDAO serviceOptionDAO;
	
	private String BASE_URL = "https://developers.zomato.com/api/v2.1/search?entity_id=287&entity_type=city&apikey=cc747fb03ab46627bb5969ca001acc2a";
	private RestTemplate restTemplate = new RestTemplate();
	private static String API_KEY = "cc747fb03ab46627bb5969ca001acc2a";
	
	public RestaurantController(UserDAO userDAO, QuestionnaireDAO prefDAO, CuisineDAO cuisineDAO, NeighborhoodDAO neighborhoodDAO, CategoryDAO categoryDAO, ServiceOptionDAO serviceOptionDAO) {
		this.prefDAO = prefDAO;
		this.userDAO = userDAO;
		this.cuisineDAO = cuisineDAO;
		this.neighborhoodDAO = neighborhoodDAO;
		this.categoryDAO = categoryDAO;
		this.serviceOptionDAO = serviceOptionDAO;
	}
	
	//MAKE SURE TO ADD USER ID BACK INTO THE VALUE AND AUTHENTICATE
	
	@RequestMapping(value = "/questionnaire/cuisine", method = RequestMethod.GET)
	public List<Cuisine> getAllCuisine() {
		return cuisineDAO.getAllCuisine();
	}
	
	@RequestMapping(value = "/questionnaire/neighborhood", method = RequestMethod.GET)
	public List<Neighborhood> getAllNeighborhoods() {
		return neighborhoodDAO.getAllNeighborhoods();
	}
	
	@RequestMapping(value = "/questionnaire/category", method = RequestMethod.GET)
	public List<Category> getAllCategories() {
		return categoryDAO.getAllCategories();
	}
	
	@RequestMapping(value = "/questionnaire/serviceoption", method = RequestMethod.GET)
	public List<Category> getAllServiceOptions() {
		return serviceOptionDAO.getAllServiceOptions();
	}
	
	@RequestMapping(value = "/questionnaire/{user_id}", method = RequestMethod.POST)
	void createNewQuestionnaire(@PathVariable int user_id, @RequestBody Questionnaire ques) {
		prefDAO.createNewQuestionnaire(user_id, ques);
	}
	
	@RequestMapping(value = "/questionnaire/{user_id}", method = RequestMethod.PUT)
	void updateExistingQuestionnaire(@PathVariable int user_id, @RequestBody Questionnaire ques) {
		prefDAO.updateQuestionnaire(user_id, ques);
	}
	
	@RequestMapping(value = "/questionnaire/{user_id}", method = RequestMethod.GET)
	public Questionnaire getQuestionnnaireByUser(@PathVariable int user_id) {
		return prefDAO.getAnswers(user_id);
	}
	
}
