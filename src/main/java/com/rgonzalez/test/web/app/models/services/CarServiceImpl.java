package com.rgonzalez.test.web.app.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgonzalez.test.web.app.models.dao.CarDao;
import com.rgonzalez.test.web.app.models.entity.Car;

import reactor.core.publisher.Flux;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarDao carRepository;
	
	@Override
	public Flux<Car> getAll() {		
		return Flux.fromIterable(carRepository.findAll());
	}

	@Override
	public Car getbyId(Integer id) {	
		return carRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Car obj) {
		carRepository.save(obj);		
	}

	@Override
	public void delete(Car obj) {
		carRepository.delete(obj);	
	}

	@Override
	public void deletebyId(Integer id) {
		carRepository.deleteById(id);
	}

}
