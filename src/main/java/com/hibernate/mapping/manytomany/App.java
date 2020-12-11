package com.hibernate.mapping.manytomany;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		/* Creating employee objects */

		Employee employee = new Employee();
		Employee employee2 = new Employee();

		employee.setEmployeeId(101);
		employee.setEmployeeName("Hemendra Singh Chouhan");

		employee2.setEmployeeId(102);
		employee2.setEmployeeName("Sunny Singh Chouhan");

		/* Creating the project objects */

		Project project = new Project();
		Project project2 = new Project();
		Project project3 = new Project();
		Project project4 = new Project();

		project.setProjectId(1001);
		project.setProjectTitle("Employee Tracking System");

		project2.setProjectId(1002);
		project2.setProjectTitle("Bus Tracking System");

		project3.setProjectId(1003);
		project3.setProjectTitle("File Tracking System");

		project4.setProjectId(1004);
		project4.setProjectTitle("Phone Tracking System");

		/* Assigning projects to employees */

		employee.setProjects(Arrays.asList(project, project2, project3, project4));
		employee2.setProjects(Arrays.asList(project, project2));

		/* Persisting data to the database */

		session.save(employee);
		session.save(employee2);
		session.save(project);
		session.save(project2);
		session.save(project3);
		session.save(project4);
		transaction.commit();

	}
}
