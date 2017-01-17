package com.david.hibernateapp.controlle;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.david.hibernateapp.domain.User;
import com.david.hibernateapp.service.USerService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	USerService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
	public String home(@ModelAttribute User user) {
		
		return "addUser";
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUSer(@ModelAttribute User user) {
		service.save(user);		
		return "added";
	}
	
}
