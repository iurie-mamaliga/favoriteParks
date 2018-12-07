package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDAO implements SurveyDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Survey> getAllSurveys(){
		List<Survey> allSurveys = new ArrayList<>();
		
		String sqlSelectAllSurveys = "SELECT * FROM survey_result;";  //need to change this to get only surveys with 2 parks or more
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		
		while(results.next()) {
			Survey survey = new Survey();
			survey.setSurveyId(results.getInt("surveyid"));
			survey.setParkCode(results.getString("parkcode"));
			survey.setEmailAddress(results.getString("emailaddress"));
			survey.setState(results.getString("state"));
			survey.setActivityLevel(results.getString("activitylevel"));
			
			allSurveys.add(survey);
		}
		return allSurveys;
	}
	
	public void saveNewSurvey(Survey newSurvey) {
		String sqlInsertSurvey = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertSurvey, newSurvey.getParkCode(), newSurvey.getEmailAddress(), newSurvey.getState(), newSurvey.getActivityLevel());
	}	
}