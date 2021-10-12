package com.rgonzalez.test.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgonzalez.test.web.app.models.dao.IRepository;
import com.rgonzalez.test.web.app.models.entity.Car;

@Service
public class CarService implements IService<Car>{

	@Autowired
	private IRepository<Car> carRepository;
	
	@Override
	public List<Car> getAll() {		
		return carRepository.getAll();
	}

	@Override
	public Car getbyId(Integer id) {	
		return carRepository.getbyId(id);
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
		carRepository.deletebyID(id);
	}

}
