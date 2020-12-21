package com.hibernate.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
There are some states of the object which are mentioned as:
	
	Transient -- State which is till the object reaches the session object or we can say before that, once
	you initialize the values by the help of setters or constructors.
	
	Persistent -- State which is till the object reaches the database this is between we session and 				   				  database.
	
	Detached -- When we close the session in that case the object is not available with the session.
	
	session.close() or session.clear() is when invoked.
	
	Removed -- Deleted values 
	
	session.delete().

*/

public class App {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		/*
		 * Declaration of information related to the candidate and till here we do not
		 * have the same associated with the session, till this point upto which it is
		 * not associated with the session and values are initialized it is in the
		 * Transient state.
		 */

		/* Transient State */

		CandidateInfo candidateInfo = new CandidateInfo();
		candidateInfo.setId(101);
		candidateInfo.setName("Hemendra Singh Chouhan");
		candidateInfo.setCountry("India");

		Session session = sessionFactory.openSession();

		/* Persistent State */

		session.save(candidateInfo);

		Transaction transaction = session.beginTransaction();
		
		transaction.commit();
		
		/* Detached State */
		
		session.close();
	}
}
