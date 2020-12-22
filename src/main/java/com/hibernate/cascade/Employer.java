package com.hibernate.cascade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String country;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<EmployerEmployee> employeremployees;

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", country=" + country + ", employeremployees="
				+ employeremployees + "]";
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<EmployerEmployee> getEmployeremployees() {
		return employeremployees;
	}

	public void setEmployeremployees(List<EmployerEmployee> employeremployees) {
		this.employeremployees = employeremployees;
	}

	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
