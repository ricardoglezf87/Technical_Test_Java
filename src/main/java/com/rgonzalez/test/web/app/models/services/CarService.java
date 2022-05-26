package com.rgonzalez.test.web.app.models.services;

import java.util.List;

import com.rgonzalez.test.web.app.models.entity.Car;

public interface CarService {
	
	public List<Car> getAll();
	public Car getbyId(Integer id);
	public void save(Car obj);
	public void delete(Car obj);
	public void deletebyId(Integer id);
	
}
