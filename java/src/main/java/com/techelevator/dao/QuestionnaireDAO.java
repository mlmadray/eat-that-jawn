package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Questionnaire;

public interface QuestionnaireDAO {
	
	//TODO: GET all questionnaire fields from database by user ID
	public Questionnaire getAnswers(int userId);
	//TODO: POST initial questionnaire filled out by user ID
	void createNewQuestionnaire(int userId, Questionnaire ques);
	//TODO: PUT updated fields when updated by user ID
	void updateQuestionnaire(int UserId, Questionnaire ques);
}
