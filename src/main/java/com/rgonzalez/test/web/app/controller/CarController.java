package com.rgonzalez.test.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rgonzalez.test.web.app.dao.IRepository;
import com.rgonzalez.test.web.app.models.Brand;
import com.rgonzalez.test.web.app.models.Car;
import com.rgonzalez.test.web.app.models.Model;

import com.google.gson.Gson;   

@Controller
public class CarController {

	@Autowired
	private IRepository<Car> carRepository;
	
	@Autowired
	private IRepository<Brand> brandRepository;
	
	@Autowired
	private IRepository<Model> modelRepository;
	

	@ModelAttribute("models")
	public List<Model> models(){
		return modelRepository.getAll();
	}
	
	@ModelAttribute("brands")
	public List<Brand> brands(){
		return brandRepository.getAll();
	}

	@GetMapping(value = "/car/list")
	public String List(org.springframework.ui.Model model) {
		model.addAttribute("title", "List cars");
		model.addAttribute("cars", carRepository.getAll());
		return "car/list";
	}
	
	@GetMapping(value="/car/add")
	public String add(org.springframework.ui.Model model){
		model.addAttribute("title","Add new car");
		model.addAttribute("car",new Car());
		return "car/add";
	}

	@GetMapping(value ="/car/edit/{id}")
	public String edit(@PathVariable(value="id")Integer id,org.springframework.ui.Model model) {
		
		Car car = null;
		
		if (id>0){
			car = carRepository.getbyId(id);
		}else {
			return "redirect:/car/list";
		}
		
		model.addAttribute("car",car);
		
		return "car/edit";
	}
	
	@PostMapping(value="/car/save")
	public String save(Car car) {
		carRepository.save(car);
		return "redirect:car/list";
	}
	
//	@ResponseBody
//	@GetMapping(value="loadModels/{id}")
//	public String loadModels(@PathVariable(value="id")Integer id,org.springframework.ui.Model model){
//		Gson gson = new Gson();
//		return gson.toJson(brandRepository.getbyId(id).getModels());
//	}
	
}
