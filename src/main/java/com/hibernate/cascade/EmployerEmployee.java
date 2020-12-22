package com.hibernate.cascade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class EmployerEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Employer> employers;

	@Override
	public String toString() {
		return "EmployerEmployee [id=" + id + ", name=" + name + ", employers=" + employers + "]";
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

	public List<Employer> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Employer> employers) {
		this.employers = employers;
	}

	public EmployerEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
