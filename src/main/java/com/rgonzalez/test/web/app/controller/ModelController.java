package com.rgonzalez.test.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.rgonzalez.test.web.app.dao.IRepository;
import com.rgonzalez.test.web.app.models.Brand;
import com.rgonzalez.test.web.app.models.Model;



@Controller
public class ModelController {

	@Autowired
	private IRepository<Brand> brandRepository;
	
	@Autowired
	private IRepository<Model> modelRepository;
	
	@GetMapping(value="model/list")
	public String list(org.springframework.ui.Model model)
	{
		model.addAttribute("title","Brands and Models");
		model.addAttribute("brands",brandRepository.getAll());
		model.addAttribute("models",modelRepository.getAll());
		return "model/list";
	}
	
}
