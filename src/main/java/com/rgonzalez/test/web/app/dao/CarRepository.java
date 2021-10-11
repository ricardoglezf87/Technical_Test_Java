package com.rgonzalez.test.web.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rgonzalez.test.web.app.models.Car;

@Repository
public class CarRepository implements IRepository<Car>{
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Car> getAll() { 
		return em.createQuery("from cars").getResultList();
	}

	@Transactional(readOnly=true)
	@Override
	public Car getbyId(Integer id) {		
		return em.find(Car.class, id);
	}

	@Transactional
	@Override
	public void save(Car obj) {
		if (obj.getId()!= null && obj.getId()>0)
			em.merge(obj);
		else
			em.persist(obj);
	}

	@Transactional
	@Override
	public void delete(Car car) {
		em.remove(car);		
	}

	@Transactional
	@Override
	public void deletebyID(Integer id) {
		em.remove(getbyId(id));		
	}

}
