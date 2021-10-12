package com.rgonzalez.test.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgonzalez.test.web.app.models.dao.IRepository;
import com.rgonzalez.test.web.app.models.entity.Model;

@Service
public class ModelService implements IService<Model>{

	@Autowired
	private IRepository<Model> modelRepository;
	
	@Override
	public List<Model> getAll() {		
		return modelRepository.getAll();
	}

	@Override
	public Model getbyId(Integer id) {	
		return modelRepository.getbyId(id);
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
		modelRepository.deletebyID(id);
	}

}
