package com.rgonzalez.Test.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cars")
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1263616254732307813L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numberplate;
	private Brand brand;
	private Model model;
	private Double price;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the numberplate
	 */
	public String getNumberplate() {
		return numberplate;
	}

	/**
	 * @param numberplate the numberplate to set
	 */
	public void setNumberplate(String numberplate) {
		this.numberplate = numberplate;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	public Car(Integer id, String numberplate, Brand brand, Model model, Double price) {
		this.id = id;
		this.numberplate = numberplate;
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	public Car() {
	}

}
