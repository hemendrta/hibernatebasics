package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*We have 2 entities which are Question and Answer for each question there is only one answer and thus there is
one to one mapping or relationship which has been implemented.
*/
public class App {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		/* Creating the object for question */

		Question question1 = new Question();
		question1.setQuestionId(1);
		question1.setQuestion("What is the return type of predicate?");

		/* Creating answer object */

		Answer answer1 = new Answer();

		answer1.setAnswerId(1);
		answer1.setAnswer("Boolean");
		question1.setAnswer(answer1);

		session.save(answer1);
		session.save(question1);

		transaction.commit();

		sessionFactory.openSession();

	}
}
