package com.rgonzalez.Test.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="models")
public class Model implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8404409444069077883L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Brand brand;
	private String descrip;

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
	 * @return the descrip
	 */
	public String getDescrip() {
		return descrip;
	}

	/**
	 * @param descrip the descrip to set
	 */
	public void setDescrip(String descrip) {
		this.descrip = descrip;
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

	public Model(Integer id, String descrip, Brand brand) {
		this.id = id;
		this.brand = brand;
		this.descrip = descrip;
	}

	public Model() {
	}

}
