package com.techelevator.model;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	
	@Before
	public void setup() {
		user = new User(new Long(12),"Hannah","password","user");
	}
	
	@Test
	public void checkIfActivated() {
		Assert.assertTrue(user.isActivated());
	}
	
	@Test
	public void equals() {
		Assert.assertTrue(user.equals(user));
	}

}
