package com.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;
	@OneToOne(targetEntity = AadharDetails.class, cascade = CascadeType.ALL)
	private AadharDetails aadharDetails;

	public AadharDetails getAadharDetails() {
		return aadharDetails;
	}

	public void setAadharDetails(AadharDetails aadharDetails) {
		this.aadharDetails = aadharDetails;
	}

	public User(int id, String name, String city, AadharDetails aadharDetails) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.aadharDetails = aadharDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
