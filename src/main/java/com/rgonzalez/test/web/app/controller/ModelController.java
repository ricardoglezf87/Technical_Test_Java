package com.rgonzalez.test.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.rgonzalez.test.web.app.models.services.*;

@Controller
public class ModelController {

	@Autowired
	private BrandService brandService;
	
	@GetMapping(value="model/list")
	public String list(org.springframework.ui.Model model)
	{
		model.addAttribute("title","Brands and Models");
		
		IReactiveDataDriverContextVariable brandsDataDrivenMode =
                new ReactiveDataDriverContextVariable(brandService.getAll(), 1);
		
		model.addAttribute("brands",brandsDataDrivenMode);

		return "model/list";
	}
	
}
