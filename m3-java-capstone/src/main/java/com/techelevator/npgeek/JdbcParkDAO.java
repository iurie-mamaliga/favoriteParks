package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<ParksWithSurveys> getParksWithSurveys(){
		List<ParksWithSurveys> parksWithSurveys = new ArrayList<>();
		String sqpSelectParksWithSurveys = "SELECT COUNT(survey_result.parkcode) AS parks, survey_result.parkcode, park.parkname  FROM survey_result " + 
				"JOIN park ON park.parkcode = survey_result.parkcode GROUP BY park.parkname, survey_result.parkcode ORDER BY parks DESC, parkname ASC;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqpSelectParksWithSurveys);
		while(results.next()) {
			ParksWithSurveys park = new ParksWithSurveys();
			park.setNumberOfSurveys(results.getInt("parks"));
			park.setParkCode(results.getString("parkcode"));
			park.setParkName(results.getString("parkname"));
			
			parksWithSurveys.add(park);	
		}
		return parksWithSurveys;
	}
	
	
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			Park park = new Park();
			park.setParkCode(results.getString("parkcode"));
			park.setParkName(results.getString("parkname"));
			park.setState(results.getString("state"));
			park.setAcreage(results.getInt("acreage"));
			park.setElevationInFeet(results.getInt("elevationinfeet"));
			park.setMilesOfTrail(results.getDouble("milesoftrail"));
			park.setNumberOfCampsites(results.getInt("numberofcampsites"));
			park.setClimate(results.getString("climate"));
			park.setYearFounded(results.getInt("yearfounded"));
			park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
			park.setInspirationalQuote(results.getString("inspirationalquote"));
			park.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
			park.setEntryFee(results.getDouble("entryfee"));
			park.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
			park.setParkDescription(results.getString("parkdescription"));
			allParks.add(park);
		}
		return allParks;
	}
	
	public Park getParkByParkCode(String parkCode) {
		String sqlSelectAllParks = "SELECT * FROM park WHERE parkcode = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks, parkCode);
		
		Park park = new Park();
		if (results.next()) {
			park.setParkCode(results.getString("parkcode"));
			park.setParkName(results.getString("parkname"));
			park.setState(results.getString("state"));
			park.setAcreage(results.getInt("acreage"));
			park.setElevationInFeet(results.getInt("elevationinfeet"));
			park.setMilesOfTrail(results.getDouble("milesoftrail"));
			park.setNumberOfCampsites(results.getInt("numberofcampsites"));
			park.setClimate(results.getString("climate"));
			park.setYearFounded(results.getInt("yearfounded"));
			park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
			park.setInspirationalQuote(results.getString("inspirationalquote"));
			park.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
			park.setEntryFee(results.getDouble("entryfee"));
			park.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
			park.setParkDescription(results.getString("parkdescription"));
		} else {
			return null;
		}
		return park;
	}
}
