package com.mapping;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Array;

public class App {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		/* creating certificates */

		Certificate certificate = new Certificate();
		certificate.setCertificateId(101);
		certificate.setCertificateName("Java Certification");

		Certificate certificate1 = new Certificate();
		certificate1.setCertificateId(102);
		certificate1.setCertificateName("Oracle Certification");

		Certificate certificate2 = new Certificate();
		certificate2.setCertificateId(103);
		certificate2.setCertificateName("Docker Certification");

		Certificate certificate3 = new Certificate();
		certificate3.setCertificateId(104);
		certificate3.setCertificateName("Testing Certification");

		/* creating person */

		Person person = new Person();
		person.setAadhar(123456789);
		person.setName("Hemendra Singh Chouhan");
		person.setEmail("hemendra.singh.c@outlook.com");
		person.setCertificates(Arrays.asList(certificate, certificate1, certificate2, certificate3));

		/* setting the person for the certificates so that can have joined table */

		certificate.setPerson(person);
		certificate1.setPerson(person);
		certificate2.setPerson(person);
		certificate3.setPerson(person);

		/* persisting certificate objects */

		session.save(certificate);
		session.save(certificate1);
		session.save(certificate2);
		session.save(certificate3);

		/* persisting person object */

		session.save(person);

		transaction.commit();

		/* Fetching information from the database */

		Person person2 = session.get(Person.class, 123456789);
		System.out.println(person2.getAadhar() + " : " + person2.getName());

		for (Certificate certificate4 : person2.getCertificates()) {
			System.out.println(certificate4.getCertificateId() + " : " + certificate4.getCertificateName());
		}

		session.close();

	}

}
