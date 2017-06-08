package com.testweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("Account")
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(){
		return "home";
	}
	
	@RequestMapping("/About")
	public String about(){
		return "about";
	}
}
