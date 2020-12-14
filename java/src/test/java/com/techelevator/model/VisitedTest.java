package com.techelevator.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VisitedTest {
	private Visited visit;
	
	@Before
	public void setup() {
		visit = new Visited(1,857,"Test_Restaurant");
	}
	
	@Test
	public void getUserId() {
		Assert.assertEquals(1, visit.getUserId());
	}
	@Test
	public void getRestId() {
		Assert.assertEquals(857, visit.getRestaurantId());
	}
	@Test
	public void getName() {
		Assert.assertEquals("Test_Restaurant",visit.getRestaurantName() );
	}
}
