package com.hibernate.cascade;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*Example of cascading: Persisting the main entity and dependent enstities will be persisted automatically.*/

public class App {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employer employer=new Employer();
		employer.setName("Shankaraay Technolgies");
		employer.setCountry("India");
		
		Employer employer1=new Employer();
		employer1.setName("Tech Evaluator");
		employer1.setCountry("India");
		
		EmployerEmployee employee=new EmployerEmployee();
		employee.setName("Hemendra Singh Chouhan");
		
		EmployerEmployee employee1=new EmployerEmployee();
		employee1.setName("Nisha Singh Chouhan");
		
		EmployerEmployee employee2=new EmployerEmployee();
		employee2.setName("Subhash Singh Chouhan");
		
		EmployerEmployee employee3=new EmployerEmployee();
		employee3.setName("Aditi Singh Chouhan");
		
		employer.setEmployeremployees(Arrays.asList(employee,employee1));
		employer1.setEmployeremployees(Arrays.asList(employee2,employee3,employee1));
		
		session.save(employer);
		session.save(employer1);
		transaction.commit();
		session.close();
		
		
	}

}
