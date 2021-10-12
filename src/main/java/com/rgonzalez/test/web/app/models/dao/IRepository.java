package com.rgonzalez.test.web.app.models.dao;
import java.util.List;

public interface IRepository<T> {
	
	public List<T> getAll();
	public T getbyId(Integer id);
	public void save(T car);
	public void delete(T car);
	public void deletebyID(Integer id);
	
}
