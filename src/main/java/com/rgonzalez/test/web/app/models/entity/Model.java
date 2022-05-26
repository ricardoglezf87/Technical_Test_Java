package com.rgonzalez.test.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;



@Data
@Entity(name = "models")
public class Model implements Serializable {

	private static final long serialVersionUID = 7421633883167661671L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
		
	private String descrip;	
}
