package com.rgonzalez.test.web.app.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgonzalez.test.web.app.models.dao.ModelDao;
import com.rgonzalez.test.web.app.models.entity.Model;

import reactor.core.publisher.Flux;

@Service
public class ModelServiceImpl implements ModelService{

	@Autowired
	private ModelDao modelRepository;
	
	@Override
	public Flux<Model> getAll() {		
		return Flux.fromIterable(modelRepository.findAll());
	}
	@Override
	public Model getbyId(Integer id) {			
		return modelRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Model obj) {
		modelRepository.save(obj);		
	}

	@Override
	public void delete(Model obj) {
		modelRepository.delete(obj);	
	}

	@Override
	public void deletebyId(Integer id) {
		modelRepository.deleteById(id);
	}

}
