package com.rgonzalez.test.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgonzalez.test.web.app.models.dao.IRepository;
import com.rgonzalez.test.web.app.models.entity.Brand;

@Service
public class BrandService implements IService<Brand>{

	@Autowired
	private IRepository<Brand> brandRepository;
	
	@Override
	public List<Brand> getAll() {		
		return brandRepository.getAll();
	}

	@Override
	public Brand getbyId(Integer id) {	
		return brandRepository.getbyId(id);
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
		brandRepository.deletebyID(id);
	}

}
