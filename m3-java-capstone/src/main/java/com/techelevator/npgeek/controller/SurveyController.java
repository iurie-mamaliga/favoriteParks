package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;
import com.techelevator.npgeek.ParksWithSurveys;
import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.SurveyDAO;

@Controller
public class SurveyController {

	@Autowired
	ParkDAO parkDao;

	@Autowired
	private SurveyDAO surveyDAO;

	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String displaySurveyPage(Model modelHolder) {
		if (!modelHolder.containsAttribute("survey")) {
			modelHolder.addAttribute("survey", new Survey());
		}
		List<Park> parks = parkDao.getAllParks();
		modelHolder.addAttribute("parks", parks);

		return "survey";
	}

	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String saveReview(@Valid @ModelAttribute("survey") Survey surveyFormValues, BindingResult result,
			RedirectAttributes flash) {

		if (result.hasErrors()) {
			flash.addFlashAttribute("survey", surveyFormValues);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/survey";
		}
		surveyDAO.saveNewSurvey(surveyFormValues);
		flash.addFlashAttribute("message", "You successfully submited a survey!");
		return "redirect:/favoriteParks";
	}

	@RequestMapping("/favoriteParks")
	public String displayFavoriteParksPage(HttpServletRequest req) {
		List<ParksWithSurveys> parksWithSurveys = parkDao.getParksWithSurveys();
		req.setAttribute("parksWithSurveys", parksWithSurveys);
		return "favoriteParks";
	}

}
