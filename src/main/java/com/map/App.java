package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*We have 2 entities which are Question and Answer for each question there is only one answer and thus there is
one to one mapping or relationship which has been implemented.

We have made this bi-directional by using one to one in both the entities, this will ensure that the primary 
key of of one is present in the other.
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

		Question question2 = new Question();
		question2.setQuestionId(2);
		question2.setQuestion("What are functional interfaces?");

		/* Creating answer object */

		Answer answer1 = new Answer();

		answer1.setAnswerId(101);
		answer1.setAnswer("Boolean");
		question1.setAnswer(answer1);
		answer1.setQuestion(question1);
		Answer answer2 = new Answer();

		answer2.setAnswerId(102);
		answer2.setAnswer("An interface which has only one abstract method, can have default and static method.");
		answer2.setQuestion(question2);
		question2.setAnswer(answer2);

		session.save(answer1);
		session.save(question1);

		session.save(answer2);
		session.save(question2);

		transaction.commit();

		Question question = session.get(Question.class, 1);
		System.out.println(question.getQuestion());
		System.out.println(question.getAnswer().getAnswer());
		
		sessionFactory.openSession();

	}
}
