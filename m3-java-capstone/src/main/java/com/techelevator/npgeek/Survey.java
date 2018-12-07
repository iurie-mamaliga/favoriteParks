package com.techelevator.npgeek;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	public int surveyId;
	@NotBlank(message = "Email is Required!")
	@Email(message = "Email must be a valid email address!")
	@Size(max = 20, message = "Email can't be over 100 character!")
	public String emailAddress;
	public String parkCode;
	public String state;
	public String activityLevel;

	public Survey() {

	}

	public Survey(String parkCode, String emailAddress, String state, String activityLevel) {
		this.parkCode = parkCode;
		this.emailAddress = emailAddress;
		this.state = state;
		this.activityLevel = activityLevel;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
}
