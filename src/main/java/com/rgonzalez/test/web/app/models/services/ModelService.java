package com.rgonzalez.test.web.app.models.services;

import java.util.List;

import com.rgonzalez.test.web.app.models.entity.Model;

public interface ModelService {
	
	public List<Model> getAll();
	public Model getbyId(Integer id);
	public void save(Model obj);
	public void delete(Model obj);
	public void deletebyId(Integer id);
	
}
