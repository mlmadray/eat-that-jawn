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
import com.techelevator.model.Category;
import com.techelevator.model.Cuisine;
import com.techelevator.model.Favorites;
import com.techelevator.model.Neighborhood;


@RestController
@CrossOrigin

public class RestaurantController {
	private UserDAO userDAO;
	private CuisineDAO cuisineDAO;
	private NeighborhoodDAO neighborhoodDAO;
	private CategoryDAO categoryDAO;
	private FavoritesDAO favoritesDAO;
	
	
	
	public RestaurantController(UserDAO userDAO, CuisineDAO cuisineDAO, NeighborhoodDAO neighborhoodDAO, CategoryDAO categoryDAO, FavoritesDAO favoritesDAO) {
		this.userDAO = userDAO;
		this.cuisineDAO = cuisineDAO;
		this.neighborhoodDAO = neighborhoodDAO;
		this.categoryDAO = categoryDAO;
		this.favoritesDAO = favoritesDAO; 
		
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
	
	@RequestMapping(value = "/favorites/{userId}", method = RequestMethod.PUT)
	public void updateFavorite(@RequestBody Favorites fave) {
		favoritesDAO.updateFavorite(fave);
	}
	
	@RequestMapping(value = "/favorites/{userId}", method = RequestMethod.DELETE)
	public void deleteFavorite(@PathVariable int userId, @RequestBody Favorites fav) {
		favoritesDAO.delete(userId, fav);
	}
	
}
