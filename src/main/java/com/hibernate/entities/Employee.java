package com.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity /* This is to specify that the table or the bean class is mentioned class. */
public class Employee {

	@Id /* This is to tell that the field just mentioned below is the primary key */
	private int employeeId;
	private String employeeName;
	private String employeeCity;
	private Contact contactInformation;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String employeeName, String employeeCity, Contact contactInformation) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeCity = employeeCity;
		this.contactInformation = contactInformation;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public Contact getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(Contact contactInformation) {
		this.contactInformation = contactInformation;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeCity="
				+ employeeCity + ", contactInformation=" + contactInformation + "]";
	}

}
