package com.rgonzalez.Test.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Brands")
public class Brand implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5987677651271467233L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String Descrip;

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
		return Descrip;
	}

	/**
	 * @param descrip the descrip to set
	 */
	public void setDescrip(String descrip) {
		Descrip = descrip;
	}

	public Brand(Integer id, String descrip) {
		this.id = id;
		Descrip = descrip;
	}

	public Brand() {
	}

}
