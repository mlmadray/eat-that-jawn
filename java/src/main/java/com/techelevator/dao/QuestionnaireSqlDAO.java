package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Questionnaire;

@Service
public class QuestionnaireSqlDAO implements QuestionnaireDAO {
	private JdbcTemplate jdbcTemplate;
	
	public QuestionnaireSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Questionnaire getAnswers(int user_id) {
		Questionnaire questionnaire = new Questionnaire();
		String sql = "SELECT neighborhood, cuisine, category, service_option, username " +
					"FROM questionnaire WHERE username = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user_id);
		if(results.next()) {
			questionnaire = mapRowToQuestionnaire(results);
		}
		return questionnaire;
	}

	@Override
	public void createNewQuestionnaire( int user_id, Questionnaire ques) {
		jdbcTemplate.update("INSERT INTO questionnaire (neighborhood, cuisine, category, service_option, user_id) " +
							"VALUES (?, ?, ?, ?, ?);", ques.getNeighborhood(), ques.getCuisine(), ques.getCategory(),ques.getServiceOption(), user_id); 
	}

	@Override
	public void updateQuestionnaire(int user_id, Questionnaire ques) {
		jdbcTemplate.update("UPDATE questionnaire SET neighborhood = ?, cuisine = ?, category = ?, service_option = ? " +
							"WHERE user_id = ?",  ques.getNeighborhood(), ques.getCuisine(),ques.getCategory(), ques.getServiceOption(), user_id);
	}
	
	private Questionnaire mapRowToQuestionnaire(SqlRowSet ques) {
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setCategory(ques.getString("category"));
		questionnaire.setNeighborhood(ques.getString("neighborhood"));
		questionnaire.setCuisine(ques.getString("cuisine"));
		questionnaire.setServiceOption(ques.getString("service_option"));
		questionnaire.setUserId(ques.getInt("user_id"));
		return questionnaire;
	}

	
}
