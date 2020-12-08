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

import com.techelevator.dao.CuisineDAO;
import com.techelevator.dao.QuestionnaireDAO;
import com.techelevator.dao.RestaurantReactionsDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.ResLocation;
import com.techelevator.model.Questionnaire;
import com.techelevator.model.Restaurant;

@RestController
@CrossOrigin

public class RestaurantController {
	private UserDAO userDAO;
	private QuestionnaireDAO prefDAO;
	private RestaurantReactionsDAO restReactDAO;
	private WebService webService;
	private CuisineDAO cuisineDAO;
	
	private String BASE_URL = "https://developers.zomato.com/api/v2.1/search?entity_id=287&entity_type=city&apikey=cc747fb03ab46627bb5969ca001acc2a";
	private RestTemplate restTemplate = new RestTemplate();
	private static String API_KEY = "cc747fb03ab46627bb5969ca001acc2a";
	
	public RestaurantController(UserDAO userDAO, QuestionnaireDAO prefDAO, RestaurantReactionsDAO restReactDAO, CuisineDAO cuisineDAO) {
		this.prefDAO = prefDAO;
		this.restReactDAO = restReactDAO;
		this.userDAO = userDAO;
		this.cuisineDAO = cuisineDAO;
	}
	
	@RequestMapping(value = "/cuisine/{cuisine_type}", method = RequestMethod.GET)
	public int getCuisineId(@PathVariable String cuisine_type) {
		return cuisineDAO.getSingleCuisine(cuisine_type).getZomatoCuisineId();
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
	
	
	@RequestMapping(value = "/restaurants/{user_id}", method = RequestMethod.GET)
	public List<Restaurant> getAllLikedRestaurants(@PathVariable int user_id) {
		return restReactDAO.getAllLiked(user_id);
		
	}
	
	@RequestMapping(value = "/restaurants")
	public Restaurant[] getAllRestaurants() {
		Restaurant[] res = restTemplate.getForObject(BASE_URL, Restaurant[].class);
		return res;
		//return webService.getAllRestaurants();
	}
	@RequestMapping(value = "/location")
	public ResLocation getLocation() {
		ResLocation resLocation = restTemplate.getForObject("https://developers.zomato.com/api/v2.1/locations?query=PHILADELPHIA&apikey=cc747fb03ab46627bb5969ca001acc2a", ResLocation.class);
		return resLocation;
	}
	
}
