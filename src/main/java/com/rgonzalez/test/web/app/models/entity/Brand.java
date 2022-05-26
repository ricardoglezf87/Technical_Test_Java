package com.rgonzalez.test.web.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;



@Data
@Entity(name = "brands")
public class Brand implements Serializable {

	private static final long serialVersionUID = -5006993565582966415L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descrip;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "brand")
	private List<Model> models;

}
