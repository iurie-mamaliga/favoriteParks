package com.techelevator.npgeek;

public class Park {
	private String parkCode;
	private String parkName;
	private String state;
	private int acreage;
	private int elevationInFeet;
	private double milesOfTrail;
	private int numberOfCampsites;
	private String climate;
	private int yearFounded;
	private int annualVisitorCount;
	private String inspirationalQuote;
	private String inspirationalQuoteSource;
	private double entryFee;
	private int numberOfAnimalSpecies;
	private String parkDescription;
	
	public Park() {

	}

	public Park(String parkCode, String parkName, String state, int acreage, int elevationInFeet, double milesOfTrail,
			int numberOfCampsites, String climate, int yearFounded, int annualVisitorCount, String inspirationalQuote, String inspirationalQuoteSource,
			double entryFee, int numberOfAnimalSpecies) {

		this.parkCode = parkCode;
		this.parkName = parkName;
		this.state = state;
		this.acreage = acreage;
		this.elevationInFeet = elevationInFeet;
		this.milesOfTrail = milesOfTrail;
		this.numberOfCampsites = numberOfCampsites;
		this.climate = climate;
		this.yearFounded = yearFounded;
		this.annualVisitorCount = annualVisitorCount;
		this.inspirationalQuote = inspirationalQuote;
		this.inspirationalQuoteSource = inspirationalQuoteSource;
		this.entryFee = entryFee;
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
		this.parkDescription = parkDescription;
	}

	public String getParkDescription() {
		return parkDescription;
	}

	public void setParkDescription(String parkDescription) {
		this.parkDescription = parkDescription;
	}
	
	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAcreage() {
		return acreage;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}

	public int getElevationInFeet() {
		return elevationInFeet;
	}

	public void setElevationInFeet(int elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}

	public double getMilesOfTrail() {
		return milesOfTrail;
	}

	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}

	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}

	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}

	public int getAnnualVisitorCount() {
		return annualVisitorCount;
	}

	public void setAnnualVisitorCount(int annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}

	public String getInspirationalQuote() {
		return inspirationalQuote;
	}

	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}
	
	public String getInspirationalQuoteSource() {
		return inspirationalQuoteSource;
	}

	public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
		this.inspirationalQuoteSource = inspirationalQuoteSource;
	}

	public double getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(double entryFee) {
		this.entryFee = entryFee;
	}

	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}

	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}

}