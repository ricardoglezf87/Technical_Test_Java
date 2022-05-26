package com.rgonzalez.test.web.app.models.dao;
import org.springframework.data.repository.CrudRepository;
import com.rgonzalez.test.web.app.models.entity.Brand;

public interface BrandDao extends CrudRepository<Brand, Integer>{
}
