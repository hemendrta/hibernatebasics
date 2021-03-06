package com.hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entities.Address;
import com.hibernate.entities.Contact;
import com.hibernate.entities.Employee;

/*

We have to create a configuration file which is in the xml file format and has the details of connection or we can say connection properties.We usually take the name as hibernate.cfg.xml.

Mentioned are the details which are the basic ones and could be used:

<property name="connection.url">jdbc:mysql://localhost:3306/hibernatetutorial</property>
<property name="connection.username">root</property>
<property name="connection.password">root</property>
<property name="dialect">org.hibernate.dialect.MySQLDialect</property>
<property name="hbm2ddl.auto">update</property>
<property name="show_sql">true</property>

*/
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started!!!!!");

		/* This is one line format for establishing the connection. */

		/*
		 * SessionFactory factory = new
		 * Configuration().configure().buildSessionFactory();
		 */

		/* Above code can be splitted as: */

//		Configuration configuration = new Configuration();
//
//		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
////
//		System.out.println(sessionFactory.isClosed()); /* Checking if the session in open or not. */
//		CandidateSession session = sessionFactory.openSession(); /* opening the session. */
//		System.out.println(sessionFactory.isOpen()); /* checking if the session is open or not. */
//		Transaction transaction = session.beginTransaction(); /* Beginning the transaction. */
//		session.save(new Employee(101, "Hemendra Singh Chouhan", "Indore")); /* Persisting data to the table. */
//		transaction.commit(); /* Committing the changes to the database. */
//		session.close();

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		/* Creating Address object. */

		Address address = new Address();

		address.setCountry("India");
		address.setState("Madhya Pradesh");
		address.setCity("Indore");
		address.setLatitude(22.4);
		address.setLongitude(22.4);
		address.setBusAvailable(true);
		address.setTrainAvailable(false);
		address.setArrivalDate(new Date());

		/* Reading Image */

		File file = new File("src/main/java/flexton.png");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] bs = new byte[fileInputStream.available()];
		fileInputStream.read(bs);

		address.setImage(bs);

		/* Creating Employee object */

		Employee employee = new Employee();

		employee.setEmployeeId(101);
		employee.setEmployeeName("Hemendra Singh Chouhan");
		employee.setEmployeeCity("Indore");
		employee.setContactInformation(
				new Contact(7999996891l, 1234567890l, "hemendra.singh.c@outlook.com", "hemendrac142@gmail.com"));

		/* Persisting object to the database */

		session.save(address);
		session.save(employee);

		/* Committing changes to the transaction. */

		transaction.commit();

		/* Fetching object from the database */

		/*
		 * We can use get and load for fetching the data, difference between both of
		 * them will be explained in detail. If in case the value is not present in the
		 * database for the primary key then in that case get will return null whereas
		 * load will give ObjectNotFoundException but never returns null.
		 * 
		 * So use get if you are not sure whether the object exists in the database
		 * whereas use load if you are sure that data exists in the database.
		 * 
		 * 
		 * @Embeddable is used for the class for which we do not want table to be
		 * created rather the field of which we need to be associated or present in
		 * another entity. Usage of same could be seen in the Contact class which is
		 * used as a property in Employee class.
		 */

		Address address2 = session.get(Address.class, 1);
		Address address3 = session.get(Address.class, 2);
		System.out.println(address2.getAddressId() + " : " + address2.getCountry() + " : " + address2.getState() + " : "
				+ address2.getCity());

		try {
			System.out.println(address3.getAddressId() + " : " + address3.getCountry() + " : " + address3.getState()
					+ " : " + address3.getCity());
		}

		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getClass());
		}
		Employee employee2 = session.load(Employee.class, 101);

		Employee employee3 = session.load(Employee.class, 102);

		System.out.println(employee2);

		try {
			System.out.println(employee3);
		}

		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getClass());
		}
		/* Closing the session */
		session.close();

		/* closing the session factory */

		sessionFactory.close();

	}
}
