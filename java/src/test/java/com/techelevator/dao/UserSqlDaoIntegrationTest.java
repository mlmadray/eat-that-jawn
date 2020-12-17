package com.techelevator.dao;

import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import javax.sql.DataSource;

public class UserSqlDaoIntegrationTest extends DAOIntegrationTest {

    private UserSqlDAO userSqlDAO;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userSqlDAO = new UserSqlDAO(jdbcTemplate);
    }
    
    @Test
    public void returnListOfAllUsers() {
    	List <User> users = userSqlDAO.findAll();
    	Assert.assertNotNull(users);
    }

    @Test
    public void createNewUser() {
        boolean userCreated = userSqlDAO.create("TEST_USER","test_password","user");
        Assert.assertTrue(userCreated);
        User user = userSqlDAO.findByUsername("TEST_USER");
        Assert.assertEquals("TEST_USER", user.getUsername());
    }
    
    @Test
    public void updatePasswordForAUser() {
    	boolean userCreated = userSqlDAO.create("TEST_USER","test_password","user");
    	String beforePasswordChange = userSqlDAO.findByUsername("TEST_USER").getPassword();
    	
    	userSqlDAO.update("TEST_USER", "password");
    	User user = userSqlDAO.findByUsername("TEST_USER");
    	
    	Assert.assertNotEquals(user.getPassword(), beforePasswordChange);
    } 
    
    @Test
    public void getUserByID() {
    	boolean userCreated = userSqlDAO.create("TEST_USER","test_password","user");
    	User user = userSqlDAO.findByUsername("TEST_USER");
    	
    	User user2 = userSqlDAO.getUserById(user.getId());
    	
    	Assert.assertEquals(user.getUsername(), user2.getUsername());
    } 
    
   

}
