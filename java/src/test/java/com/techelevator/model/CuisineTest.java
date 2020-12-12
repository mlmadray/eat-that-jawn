package com.techelevator.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CuisineTest {
	Cuisine cuis;
	
	@Before
	public void setup() {
		cuis = new Cuisine(100, "Test_Cuisine");
	}
	
	@Test
	public void getId() {
		Assert.assertEquals(100, cuis.getZomatoCuisineId());
	}
	
	@Test
	public void getName() {
		Assert.assertEquals("Test_Cuisine",cuis.getCuisineType());
	}	

}
