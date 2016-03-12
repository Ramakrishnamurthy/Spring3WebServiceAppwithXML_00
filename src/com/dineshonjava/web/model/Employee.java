package com.dineshonjava.web.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@XmlRootElement
//XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Employee{
	@XmlElement(name="empId")
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@XmlElement(name="empName")
	private String name;
	@XmlElement(name="empAge")
	private int age;
	@XmlElement(name="empSalary")
	private int salary;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;

	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	@XmlElement
	//@OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	private Set<Address> addresses = new HashSet<Address>(0);


	public Set<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
}
