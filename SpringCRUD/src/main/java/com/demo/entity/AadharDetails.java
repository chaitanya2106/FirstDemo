package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AadharDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aadharNumber;
	private String ststus;

	public AadharDetails(long aadharNumber, String ststus) {
		super();
		this.aadharNumber = aadharNumber;
		this.ststus = ststus;
	}

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getStstus() {
		return ststus;
	}

	public void setStstus(String ststus) {
		this.ststus = ststus;
	}

}
