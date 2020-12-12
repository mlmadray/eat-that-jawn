package com.techelevator.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NeighborhoodTest {
	Neighborhood neighborhood;
	
	@Before
	public void setup() {
		neighborhood = new Neighborhood(10000, "Test_Neighborhood");
	}
	
	@Test
	public void getId() {
		Assert.assertEquals(10000, neighborhood.getLocalitySubzoneId());
	}
	
	@Test
	public void getName() {
		Assert.assertEquals("Test_Neighborhood",neighborhood.getLocalitySubzoneName() );
	}
}
