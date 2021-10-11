package com.rgonzalez.test.web.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rgonzalez.test.web.app.models.Model;

@Repository
public class ModelRepository implements IRepository<Model>{
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Model> getAll() { 
		return em.createQuery("from models").getResultList();
	}

	@Transactional(readOnly=true)
	@Override
	public Model getbyId(Integer id) {		
		return em.find(Model.class, id);
	}

	@Transactional
	@Override
	public void save(Model obj) {
		if (obj.getId()!= null && obj.getId()>0)
			em.merge(obj);
		else
			em.persist(obj);
	}

	@Transactional
	@Override
	public void delete(Model obj) {
		em.remove(obj);		
	}

	@Transactional
	@Override
	public void deletebyID(Integer id) {
		em.remove(getbyId(id));		
	}

}
