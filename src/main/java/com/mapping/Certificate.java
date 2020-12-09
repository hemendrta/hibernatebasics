package com.mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Certificate {

	@Id
	private int certificateId;
	private String certificateName;

	@ManyToOne
	private Person person;

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certificate(int certificateId, String certificateName, Person person) {
		super();
		this.certificateId = certificateId;
		this.certificateName = certificateName;
		this.person = person;
	}

	public int getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Certificate [certificateId=" + certificateId + ", certificateName=" + certificateName + ", person="
				+ person + "]";
	}

}
