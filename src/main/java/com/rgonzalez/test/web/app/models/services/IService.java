package com.rgonzalez.test.web.app.models.services;

import java.util.List;

public interface IService<T> {
	
	public List<T> getAll();
	public T getbyId(Integer id);
	public void save(T obj);
	public void delete(T obj);
	public void deletebyId(Integer id);
	
}
