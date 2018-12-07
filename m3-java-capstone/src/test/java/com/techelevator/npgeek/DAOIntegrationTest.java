package com.techelevator.npgeek;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.util.Assert;

import com.techelevator.npgeek.JdbcParkDAO;
import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;

public class DAOIntegrationTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	/* This method provides access to the DataSource for subclasses so that 
	 * they can instantiate a DAO for testing */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Test
	public void nonexistentParkCodeTest() {
		ParkDAO parkDao = new JdbcParkDAO(getDataSource());
		String nonexistentParkCode = "xxxxxxxxxxx";
		Park result = parkDao.getParkByParkCode(nonexistentParkCode);
		Assert.isNull(result);
	}
	
	@Test
	public void existingParkCodeTest() {
		ParkDAO parkDao = new JdbcParkDAO(getDataSource());
		String existingParkCode = "CVNP";
		Park result = parkDao.getParkByParkCode(existingParkCode);
		Assert.notNull(result);
	}
	
	@Test
	public void getAllParksTest() {
		ParkDAO parkDao = new JdbcParkDAO(getDataSource());
		int expectedNumberOfParks = 10;
		List<Park> result = parkDao.getAllParks();
		assertEquals(expectedNumberOfParks, result.size());
	}
		
	@Test
	public void getWeatherForecastsForExistingParkTest() {
		WeatherDAO weatherDao = new JdbcWeatherDAO(getDataSource());
		int expectedNumberOfWeatherObjects = 5;
		String existingParkCode = "CVNP";
		List<Weather> result = weatherDao.getWeatherByParkId(existingParkCode);
		assertEquals(expectedNumberOfWeatherObjects, result.size());
	}
	
	@Test
	public void getWeatherForecastsForNonexistentParkTest() {
		WeatherDAO weatherDao = new JdbcWeatherDAO(getDataSource());
		int expectedNumberOfWeatherObjects = 0;
		String nonExistentParkCode = "xxxxxxxxxx";
		List<Weather> result = weatherDao.getWeatherByParkId(nonExistentParkCode);
		assertEquals(expectedNumberOfWeatherObjects, result.size());
	}
	
	@Test
	public void getAllSurveysNotNullTest() {
		SurveyDAO surveyDao = new JdbcSurveyDAO(getDataSource());
		List<Survey> result = surveyDao.getAllSurveys();
		Assert.notNull(result);
	}
	
	@Test
	public void saveAndLookUpSurveyTest() {
		SurveyDAO surveyDao = new JdbcSurveyDAO(getDataSource());
		
		Survey testSurvey = new Survey();
		testSurvey.setSurveyId(999999);
		testSurvey.setParkCode("TEST");
		testSurvey.setEmailAddress("TEST@TEST.TEST");
		testSurvey.setState("TEST");
		testSurvey.setActivityLevel("TEST");
		surveyDao.saveNewSurvey(testSurvey);
		
		List<Survey> result = surveyDao.getAllSurveys();
	
		boolean surveyFoundInList = false;
		for (Survey s : result) {
			if (s.getParkCode().equals(testSurvey.getParkCode()) &&
				s.getEmailAddress().equals(testSurvey.getEmailAddress()) &&
				s.getState().equals(testSurvey.getState()) &&
				s.getActivityLevel().equals(testSurvey.getActivityLevel())) {
					surveyFoundInList = true;
			}
		}
		assertTrue(surveyFoundInList);
	}

}
