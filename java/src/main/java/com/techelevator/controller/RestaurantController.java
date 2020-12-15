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
import com.techelevator.dao.FavoritesDAO;
import com.techelevator.dao.NeighborhoodDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.dao.VisitedDAO;
import com.techelevator.model.Category;
import com.techelevator.model.Cuisine;
import com.techelevator.model.Favorites;
import com.techelevator.model.Neighborhood;
import com.techelevator.model.Visited;

@RestController
@CrossOrigin

public class RestaurantController {
	private UserDAO userDAO;
	private CuisineDAO cuisineDAO;
	private NeighborhoodDAO neighborhoodDAO;
	private CategoryDAO categoryDAO;
	private FavoritesDAO favoritesDAO;
	private VisitedDAO visitedDAO;
	
	
	public RestaurantController(UserDAO userDAO, CuisineDAO cuisineDAO, NeighborhoodDAO neighborhoodDAO, CategoryDAO categoryDAO, FavoritesDAO favoritesDAO, VisitedDAO visitedDAO) {
		this.userDAO = userDAO;
		this.cuisineDAO = cuisineDAO;
		this.neighborhoodDAO = neighborhoodDAO;
		this.categoryDAO = categoryDAO;
		this.favoritesDAO = favoritesDAO; 
		this.visitedDAO = visitedDAO;
	}
	
		
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
	
	@RequestMapping(value = "/favorites/{userId}", method = RequestMethod.GET)
	public List<Favorites> getAllFavoritesByUserId(@PathVariable int userId) {
		return favoritesDAO.getAllByUserId(userId);
	}
	
	@RequestMapping(value = "/favorites/{userId}", method = RequestMethod.POST)
	public void addFavorite(@RequestBody Favorites fave) {
		favoritesDAO.addFavorite(fave);
	}
	
	@RequestMapping(value = "/favorites/{userId}", method = RequestMethod.DELETE)
	public void deleteFavorite(@PathVariable int userId, @RequestBody Favorites fav) {
		favoritesDAO.delete(userId, fav);
	}
	
	@RequestMapping(value = "/visited/{userId}", method = RequestMethod.GET)
	public List<Visited> getAllVisitedByUserId(@PathVariable int userId) {
		return visitedDAO.getAllByUserId(userId);
	}
	
	@RequestMapping(value = "/visited/{userId}", method = RequestMethod.POST)
	public void addVistiedRestaurant(@RequestBody Visited visit) {
		visitedDAO.addVisit(visit);
	}
	
	@RequestMapping(value = "/visited/{userId}", method = RequestMethod.DELETE)
	public void deleteVisited(@PathVariable int userId, @PathVariable int restaurantId) {
		visitedDAO.delete(userId, restaurantId);
	}
}
