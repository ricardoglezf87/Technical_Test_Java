package com.rgonzalez.test.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.rgonzalez.test.web.app.models.entity.Car;


public interface CarDao extends CrudRepository<Car, Integer>{
}
