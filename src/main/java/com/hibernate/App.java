package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
	public static void main(String[] args) {
		System.out.println("Project Started!!!!!");

		/* This is one line format for establishing the connection. */

		/*
		 * SessionFactory factory = new
		 * Configuration().configure().buildSessionFactory();
		 */

		/* Above code can be splitted as: */

		Configuration configuration = new Configuration();

		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();

		System.out.println(sessionFactory.isClosed()); /* Checking if the session in open or not. */
		sessionFactory.openSession(); /* opening the session. */
		System.out.println(sessionFactory.isOpen()); /* checking if the session is open or not. */
	}
}
