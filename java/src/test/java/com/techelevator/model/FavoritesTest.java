package com.techelevator.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FavoritesTest {
	private Favorites fav;
	
	@Before
	public void setup() {
		fav = new Favorites(1,857,"Test_Restaurant");
	}
	
	@Test
	public void getUserId() {
		Assert.assertEquals(1, fav.getUserId());
	}
	@Test
	public void getRestId() {
		Assert.assertEquals(857, fav.getRestaurantId());
	}
	@Test
	public void getName() {
		Assert.assertEquals("Test_Restaurant",fav.getRestaurantName() );
	}
}
