package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.CaseUtils;


public class Weather {
	private String parkCode;
	private int fiveDayForecastValue;
	private int lowTemp;
	private int highTemp;
	private String forecast;
	private List<String> recommendations;

	public Weather() {
	}

	public Weather(String parkCode, int fiveDayForecastValue, int lowTemp, int highTemp, String forecast, List<String> recommendations) {
		this.parkCode = parkCode;
		this.fiveDayForecastValue = fiveDayForecastValue;
		this.lowTemp = lowTemp;
		this.highTemp = highTemp;
		this.forecast = forecast;
		this.recommendations = recommendations;
	}

	public boolean isTempOverSeventyFive() {
		if (lowTemp > 75 || highTemp > 75) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTempDifferenceExceedsTwenty() {
		if (highTemp - lowTemp > 20) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTempBelowTwenty() {
		if (highTemp < 20 || lowTemp < 20) {
			return true;
		} else {
			return false;
		}
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}

	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}

	public int getLowTemp() {
		return lowTemp;
	}

	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}

	public int getHighTemp() {
		return highTemp;
	}

	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = toPascalCase(forecast);
	}
	
	public List<String> getRecommendations() {
		List<String> recommendations = new ArrayList<String>();
		if (forecast.equals("snow")) {
			recommendations.add("Pack snowshoes");
		}
		if (forecast.equals("rain")) {
			recommendations.add("Pack rain gear");
			recommendations.add("Wear waterproof shoes");
		}
		if (forecast.equals("thunderstorms")) {
			recommendations.add("Seek shelter in active storm");
			recommendations.add("Avoid hiking on exposed ridges");
		}
		if (forecast.equals("sun")) {
			recommendations.add("Pack sunblock to avoid burns");
		}
		if (isTempOverSeventyFive()) {
			recommendations.add("Bring extra gallon of water");
		}
		if (isTempDifferenceExceedsTwenty()) {
			recommendations.add("Wear breathable layers");
		}
		if (isTempBelowTwenty()) {
			recommendations.add("Beware exposure to frigid temperatures");
		}
		return recommendations;
	}

	public static String toPascalCase(String str) {
		String newStr = CaseUtils.toCamelCase(str, false, new char[]{' '});
		return newStr;
	}
}