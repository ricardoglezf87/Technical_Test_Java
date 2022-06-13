package com.rgonzalez.test.web.app.models.services;

import java.util.List;

import com.rgonzalez.test.web.app.models.entity.Car;

import reactor.core.publisher.Flux;

public interface CarService {
	
	public Flux<Car> getAll();
	public Car getbyId(Integer id);
	public void save(Car obj);
	public void delete(Car obj);
	public void deletebyId(Integer id);
	
}
