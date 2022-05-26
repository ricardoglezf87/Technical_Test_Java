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
@Entity(name = "cars")
public class Car implements Serializable {

	private static final long serialVersionUID = -2861066154201882402L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="model_id")
	private Model model;
	private String numberplate;
	
	
	private Double price;
	
	@Override
    public String toString() {        
		return "Car [id=" + id + ", Model=" + model.toString() + ", NumberPlate=" + numberplate + ", Price=" + price + "]";
    }

}
