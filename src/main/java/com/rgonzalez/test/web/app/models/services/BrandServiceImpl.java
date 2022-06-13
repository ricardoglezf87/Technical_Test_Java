package com.rgonzalez.test.web.app.models.services;

import java.time.Duration;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgonzalez.test.web.app.models.dao.BrandDao;
import com.rgonzalez.test.web.app.models.entity.Brand;

import reactor.core.publisher.Flux;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandDao brandRepository;
	
	@Override
	public Flux<Brand> getAll() {		
		return  Flux.fromIterable(brandRepository.findAll());
	}

	@Override
	public Brand getbyId(Integer id) {	
		return brandRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Brand obj) {
		brandRepository.save(obj);		
	}

	@Override
	public void delete(Brand obj) {
		brandRepository.delete(obj);	
	}

	@Override
	public void deletebyId(Integer id) {
		brandRepository.deleteById(id);
	}

}
