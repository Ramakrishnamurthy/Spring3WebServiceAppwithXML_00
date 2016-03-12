package com.dineshonjava.web.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class Address {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int citiId;
	private String name;
	private String country;
	//@ManyToOne(fetch=FetchType.EAGER)
	@ManyToOne(fetch = FetchType.EAGER)
	@XmlTransient
	@JoinColumn(name="id")
    
	private Employee employee;
	public int getCitiId() {
		return citiId;
	}
	public void setCitiId(int citiId) {
		this.citiId = citiId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@XmlTransient
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
