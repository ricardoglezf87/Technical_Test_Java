package com.rgonzalez.test.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rgonzalez.test.web.app.models.services.*;

@Controller
public class ModelController {

	@Autowired
	private BrandService brandService;
	
	@Autowired
	private ModelService modelService;
	
	@GetMapping(value="model/list")
	public String list(org.springframework.ui.Model model)
	{
		model.addAttribute("title","Brands and Models");
		model.addAttribute("brands",brandService.getAll());
		model.addAttribute("models",modelService.getAll());
		return "model/list";
	}
	
}
