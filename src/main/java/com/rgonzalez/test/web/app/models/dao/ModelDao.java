package com.rgonzalez.test.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.rgonzalez.test.web.app.models.entity.Model;

public interface ModelDao extends CrudRepository<Model, Integer>{
}
