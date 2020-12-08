package com.techelevator.controller;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.Restaurant;

public class WebService {
	
	
	//private String BASE_URL = "https://developers.zomato.com/api/v2.1/search?entity_id=287&entity_type=city";
	private String BASE_URL = "https://developers.zomato.com/api/v2.1/search?entity_id=287&entity_type=city&apikey=cc747fb03ab46627bb5969ca001acc2a";
	private RestTemplate restTemplate = new RestTemplate();
	private static String API_KEY = "cc747fb03ab46627bb5969ca001acc2a";
	
	public WebService (String url) {
		this.BASE_URL = url;
	}
	
	public Restaurant[] getAllRestaurants() {
		//Restaurant[] res = restTemplate.exchange(BASE_URL, HttpMethod.GET, ApiEntity(), Restaurant[].class).getBody();
		Restaurant[] res = restTemplate.getForObject(BASE_URL, Restaurant[].class, API_KEY);
	
		return res;
	}
	 /*
	  public HttpEntity ApiEntity() { HttpHeaders headers = new HttpHeaders();
	  String basicAuth = "Basic " + new String(Base64.getEncoder().encode(API_KEY.getBytes())); 
	  headers.setBasicAuth("Authorization", basicAuth); 
	  HttpEntity entity = new HttpEntity(headers); 
	  return entity; 
	  }
	  */
	  
	// ProcessBuilder pb = new ProcessBuilder("curl", -X GET --header "Accept: application/json" --header "user-key: cc747fb03ab46627bb5969ca001acc2a" "https://developers.zomato.com/api/v2.1/search?entity_id=287&entity_type=city&q=19107"
	 
}
