package com.techelevator.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	Category cat;
	
	@Before
	public void setup() {
		cat = new Category(100, "Test_Category");
	}
	
	@Test
	public void getId() {
		Assert.assertEquals(100, cat.getZomatoCategoryId());
	}
	
	@Test
	public void getName() {
		Assert.assertEquals("Test_Category",cat.getCategoryName() );
	}
}
