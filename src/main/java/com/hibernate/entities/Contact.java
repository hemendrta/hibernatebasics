package com.hibernate.entities;

import javax.persistence.Embeddable;

@Embeddable 
/*
 * This annotation tells hibernate that we do not require a table to be created
 * for this entity rather this field has been declared in some other entity and
 * thus these fields have to be included in the table for the entity which has
 * this class as variable or property.
 */
public class Contact {

	private long contactNumber;
	private long alternateContactNumber;
	private String email;
	private String alternateEmail;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(long contactNumber, long alternateContactNumber, String email, String alternateEmail) {
		super();
		this.contactNumber = contactNumber;
		this.alternateContactNumber = alternateContactNumber;
		this.email = email;
		this.alternateEmail = alternateEmail;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getAlternateContactNumber() {
		return alternateContactNumber;
	}

	public void setAlternateContactNumber(long alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	@Override
	public String toString() {
		return "Contact [contactNumber=" + contactNumber + ", alternateContactNumber=" + alternateContactNumber
				+ ", email=" + email + ", alternateEmail=" + alternateEmail + "]";
	}

}
