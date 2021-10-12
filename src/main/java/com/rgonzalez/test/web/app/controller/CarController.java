package com.rgonzalez.test.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.rgonzalez.test.web.app.editors.BrandPropertyEditor;
import com.rgonzalez.test.web.app.editors.ModelPropertyEditor;
import com.rgonzalez.test.web.app.models.entity.Brand;
import com.rgonzalez.test.web.app.models.entity.Car;
import com.rgonzalez.test.web.app.models.entity.Model;
import com.rgonzalez.test.web.app.models.entity.serializers.ModelSerializer;
import com.rgonzalez.test.web.app.models.services.IService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;   

@Controller
@SessionAttributes("car")
public class CarController {

	@Autowired
	private IService<Car> carService;
	
	@Autowired
	private IService<Brand> brandService;
	
	@Autowired
	private IService<Model> modelService;
	
	@Autowired
	private BrandPropertyEditor brandpropertyeditor;
	
	@Autowired
	private ModelPropertyEditor modelpropertyeditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Brand.class, "brand", brandpropertyeditor);
		binder.registerCustomEditor(Model.class, "model", modelpropertyeditor);
	}

	@ModelAttribute("models")
	public List<Model> models(){
		return modelService.getAll();
	}
	
	@ModelAttribute("brands")
	public List<Brand> brands(){
		return brandService.getAll();
	}

	@GetMapping(value = "/car/list")
	public String List(org.springframework.ui.Model model) {
		model.addAttribute("title", "List cars");
		model.addAttribute("cars", carService.getAll());
		return "car/list";
	}
	
	@GetMapping(value="/car/form")
	public String add(org.springframework.ui.Model model){
		model.addAttribute("title","Add new car");
		model.addAttribute("car",new Car());
		return "car/form";
	}

	@GetMapping(value ="/car/form/{id}")
	public String edit(@PathVariable(value="id")Integer id,org.springframework.ui.Model model) {
		model.addAttribute("title","Edit car");
		Car car = null;
		
		if (id>0){
			car = carService.getbyId(id);
		}else {
			return "redirect:/car/list";
		}
		
		model.addAttribute("car",car);
		
		return "car/form";
	}
	
	@PostMapping(value="/car/save")
	public String save(Car car,SessionStatus status) {
		carService.save(car);
		status.setComplete();
		return "redirect:/car/list";
	}
	
	@ResponseBody
	@GetMapping(value="/car/loadmodels/{id}")
	public String loadModels(@PathVariable(value="id")Integer id){
		Gson gson = new GsonBuilder().registerTypeAdapter(Model.class, new ModelSerializer()).create();	
		return gson.toJson(brandService.getbyId(id).getModels());
	}
	
	@GetMapping(value="/car/delete/{id}")
	public String delete(@PathVariable(value="id")Integer id)
	{
		carService.deletebyId(id);
		return "redirect:/car/list";
	}
}

