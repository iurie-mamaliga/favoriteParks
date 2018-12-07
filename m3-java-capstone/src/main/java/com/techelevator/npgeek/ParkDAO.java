package com.techelevator.npgeek;

import java.util.List;

public interface ParkDAO {
	public List<Park> getAllParks();
	public Park getParkByParkCode(String parkCode);
	public List<ParksWithSurveys> getParksWithSurveys();
}