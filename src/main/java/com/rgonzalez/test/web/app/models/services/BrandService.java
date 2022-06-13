package com.rgonzalez.test.web.app.models.services;

import java.util.List;

import com.rgonzalez.test.web.app.models.entity.Brand;

import reactor.core.publisher.Flux;

public interface BrandService {
	
	public Flux<Brand> getAll();
	public Brand getbyId(Integer id);
	public void save(Brand obj);
	public void delete(Brand obj);
	public void deletebyId(Integer id);
	
}
