package com.techelevator.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.Restaurant;

public class WebService {
	
	
	private String BASE_URL = "https://developers.zomato.com/api/v2.1/search?entity_id=287&entity_type=city";
	private RestTemplate restTemplate = new RestTemplate();
	private static String API_KEY = "cc747fb03ab46627bb5969ca001acc2a";
	
	public WebService (String url) {
		this.BASE_URL = url;
	}
	
	public Restaurant[] getAllRestaurants() {
		Restaurant[] res = restTemplate.exchange(BASE_URL, HttpMethod.GET, ApiEntity(), Restaurant[].class).getBody();
		return res;
	}
	
	public HttpEntity ApiEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("user-key", API_KEY);
		HttpEntity entity = new HttpEntity(headers);
		return entity;
	}
}
