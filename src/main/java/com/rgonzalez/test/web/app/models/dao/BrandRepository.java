package com.rgonzalez.test.web.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rgonzalez.test.web.app.models.entity.Brand;

@Repository
public class BrandRepository implements IRepository<Brand>{
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Brand> getAll() { 
		return em.createQuery("from brands").getResultList();
	}

	@Transactional(readOnly=true)
	@Override
	public Brand getbyId(Integer id) {		
		return em.find(Brand.class, id);
	}

	@Transactional
	@Override
	public void save(Brand obj) {
		if (obj.getId()!= null && obj.getId()>0)
			em.merge(obj);
		else
			em.persist(obj);
	}

	@Transactional
	@Override
	public void delete(Brand obj) {
		em.remove(obj);		
	}

	@Transactional
	@Override
	public void deletebyID(Integer id) {
		em.remove(getbyId(id));		
	}

}
