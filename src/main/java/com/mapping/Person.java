package com.mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	private int aadhar;
	private String name;
	private String email;
	
	@OneToMany(mappedBy = "person")
	private List<Certificate> certificates;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int aadhar, String name, String email, List<Certificate> certificates) {
		super();
		this.aadhar = aadhar;
		this.name = name;
		this.email = email;
		this.certificates = certificates;
	}

	public int getAadhar() {
		return aadhar;
	}

	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	@Override
	public String toString() {
		return "Person [aadhar=" + aadhar + ", name=" + name + ", email=" + email + ", certificates=" + certificates
				+ "]";
	}

}
