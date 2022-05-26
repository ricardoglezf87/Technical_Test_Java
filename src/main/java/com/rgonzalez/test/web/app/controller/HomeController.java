package com.rgonzalez.test.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value={"/home","/","/index"})
	public String home(Model model)
	{
		model.addAttribute("title","Home Page");
		return "home";
	}
	
	@GetMapping(value={"/privacy"})
	public String privacy(Model model)
	{
		model.addAttribute("title","Privacy Policy");
		return "privacy";
	}
	
	
}
