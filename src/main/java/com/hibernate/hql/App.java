package com.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {

		System.out.println("Project Started!!!");

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		PersonPersonalInfo personPersonalInfo = new PersonPersonalInfo(101, "Hemendra", "hemendra@gmail.com");
		PersonPersonalInfo personPersonalInfo2 = new PersonPersonalInfo(102, "Sunny", "sunny@gmail.com");
		PersonPersonalInfo personPersonalInfo3 = new PersonPersonalInfo(103, "Aditi", "aditi@gmail.com");
		PersonPersonalInfo personPersonalInfo4 = new PersonPersonalInfo(104, "Nisha", "nisha@gmail.com");
		PersonPersonalInfo personPersonalInfo5 = new PersonPersonalInfo(105, "Subhash", "subhash@gmail.com");

		Transaction transaction = session.beginTransaction();

		session.save(personPersonalInfo);
		session.save(personPersonalInfo2);
		session.save(personPersonalInfo3);
		session.save(personPersonalInfo4);
		session.save(personPersonalInfo5);

		transaction.commit();

		/*
		 * Rather than table name that we use in SQL, here we use entity name as
		 * mentioned in the query
		 */

		String query = "from PersonPersonalInfo";

		/* Shooting the query */

		Query<PersonPersonalInfo> query2 = session.createQuery(query);

		/*
		 * Getting the list in the object which is given. Here we are getting the list
		 * of objects
		 */

		List<PersonPersonalInfo> list = query2.list();
		System.out.println("\n-----------------------------\n");
		list.forEach(t -> System.out.println(t.getName() + " : " + t.getEmail()));

		/* selecting single object */

		String query3 = "from PersonPersonalInfo where id=:x";

		Query query4 = session.createQuery(query3);
		Query parameter = query4.setParameter("x", 101);
		System.out.println(parameter.getSingleResult());
		
		/* selecting objects based on multiple criteria */
		
		String queryForMutiple="from PersonPersonalInfo where name=:x and id=:y";
		Query query5=session.createQuery(queryForMutiple);
		query5.setParameter("x", "Hemendra");
		query5.setParameter("y", 101);
		
		List<PersonPersonalInfo> list2 = query5.list();
		
		System.out.println("\n----------------------------------\n");
		
		list2.forEach(e->System.out.println(e.getEmail()));

		session.close();

	}
}
