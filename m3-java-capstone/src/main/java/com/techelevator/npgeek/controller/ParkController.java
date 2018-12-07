package com.techelevator.npgeek.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAO;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.WeatherDAO;

@Controller
@SessionAttributes("temperatureUnit")
public class ParkController {
	
	private final String DEFAULT_TEMPERATURE_UNIT = "F";
	
	@Autowired
	ParkDAO parkDao;
	
	@Autowired
	WeatherDAO weatherDao;
	
	@RequestMapping("/")
	public String displayHomePage(HttpServletRequest req) {
		List<Park> parks = parkDao.getAllParks();
		req.setAttribute("parks", parks);
		return "home";
	}
	
	@RequestMapping("/parkDetail")
	public String displayDetailPage(HttpServletRequest req, ModelMap model) {
		String parkCode = req.getParameter("parkCode");
		Park park = parkDao.getParkByParkCode(parkCode);
		if (park == null) {
			return "redirect:/";
		}
		List<Weather> weather = weatherDao.getWeatherByParkId(parkCode);
		if (model.get("temperatureUnit") == null) {
	        model.addAttribute("temperatureUnit", DEFAULT_TEMPERATURE_UNIT);
	    }
		req.setAttribute("park", park);
		req.setAttribute("weather", weather);
		
		String temperatureUnit = (String) model.get("temperatureUnit");
		req.setAttribute("temperatureUnit", temperatureUnit);
		return "parkDetail";
	}
	
	@RequestMapping(path="/changeTemperatureUnit", method=RequestMethod.POST)
	public String changeTemperatureUnit(@RequestParam String parkCode,
										@RequestParam String temperatureUnit,
										ModelMap model) throws FileNotFoundException, IOException {
		if (temperatureUnit.equals("C") || temperatureUnit.equals("F")) {
			model.addAttribute("temperatureUnit", temperatureUnit);
		} else {
			model.addAttribute("temperatureUnit", DEFAULT_TEMPERATURE_UNIT);
		}
		return "redirect:/parkDetail?parkCode=" + parkCode;
	}
	
}
