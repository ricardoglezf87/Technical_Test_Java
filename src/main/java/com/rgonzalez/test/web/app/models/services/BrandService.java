package com.rgonzalez.test.web.app.models.services;

import java.util.List;

import com.rgonzalez.test.web.app.models.entity.Brand;

public interface BrandService {
	
	public List<Brand> getAll();
	public Brand getbyId(Integer id);
	public void save(Brand obj);
	public void delete(Brand obj);
	public void deletebyId(Integer id);
	
}
