package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Questionnaire;
import com.techelevator.model.Restaurant;

@Service
public class QuestionnaireSqlDAO implements QuestionnaireDAO {
	private JdbcTemplate jdbcTemplate;
	
	public QuestionnaireSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Questionnaire getAnswers(int userId) {
		Questionnaire questionnaire = new Questionnaire();
		String sql = "SELECT first_name, city, neighborhood, cuisine, service_option " +
					"FROM questionnaire WHERE user_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		if(results.next()) {
			questionnaire = mapRowToQuestionnaire(results);
		}
		return questionnaire;
	}

	@Override
	public void createNewQuestionnaire(int userId, Questionnaire ques) {
		jdbcTemplate.update("INSERT INTO questionnaire (first_name, city, neighborhood, cuisine, service_option, user_id) " +
							"VALUES (?, ?, ?, ?, ?, ?);", ques.getFirstName(), ques.getCity(), ques.getNeighborhood(), ques.getCuisine(), ques.getServiceOption(), userId); 
	}

	@Override
	public void updateQuestionnaire(int userId, Questionnaire ques) {
		jdbcTemplate.update("UPDATE questionnaire SET first_name = ?, city = ?, neighborhood = ?, cuisine = ?, service_option = ? " +
							"WHERE user_id = ?", ques.getFirstName(), ques.getCity(), ques.getNeighborhood(), ques.getCuisine(), ques.getServiceOption(), userId);
	}
	
	private Questionnaire mapRowToQuestionnaire(SqlRowSet ques) {
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setFirstName(ques.getString("first_name"));
		questionnaire.setCity(ques.getString("city"));
		questionnaire.setNeighborhood(ques.getString("neighborhood"));
		questionnaire.setCuisine(ques.getString("cuisine"));
		questionnaire.setServiceOption(ques.getString("service_option"));
		return questionnaire;
	}

	
}
