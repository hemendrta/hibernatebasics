package com.hibernate.dataloading;

import java.util.Arrays;
import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	/*
	 * By default the fetch type is lazy we have to specify it to the eager in the
	 * entity as can be seen in candidate
	 */

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		/* creating candidates */

		Candidate candidate = new Candidate();
		Candidate candidate2 = new Candidate();
		Candidate candidate3 = new Candidate();

		candidate.setCandidateId(101);
		candidate.setCandidateName("Hemendra Singh Chouhan");

		candidate2.setCandidateId(102);
		candidate2.setCandidateName("Subhash Singh Chouhan");

		candidate3.setCandidateId(103);
		candidate3.setCandidateName("Sunny Singh Chouhan");

		/* creating sessions. */

		CandidateSession candidateSession = new CandidateSession();
		CandidateSession candidateSession2 = new CandidateSession();
		CandidateSession candidateSession3 = new CandidateSession();
		CandidateSession candidateSession4 = new CandidateSession();
		CandidateSession candidateSession5 = new CandidateSession();
		CandidateSession candidateSession6 = new CandidateSession();
		CandidateSession candidateSession7 = new CandidateSession();
		CandidateSession candidateSession8 = new CandidateSession();
		CandidateSession candidateSession9 = new CandidateSession();

		candidateSession.setSessionId(1001);
		candidateSession.setSessionTopic("Java Developer Screenig");
		candidateSession.setCandidate(candidate);

		candidateSession2.setSessionId(1002);
		candidateSession2.setSessionTopic("Frontend Screenig");
		candidateSession2.setCandidate(candidate2);

		candidateSession3.setSessionId(1003);
		candidateSession3.setSessionTopic("Frontend Screenig");
		candidateSession3.setCandidate(candidate3);

		candidateSession4.setSessionId(1004);
		candidateSession4.setSessionTopic("Java QE Screenig");
		candidateSession4.setCandidate(candidate3);

		candidateSession5.setSessionId(1005);
		candidateSession5.setSessionTopic("Java Automation Screenig");
		candidateSession5.setCandidate(candidate3);

		candidateSession6.setSessionId(1006);
		candidateSession6.setSessionTopic("Python Developer Screenig");
		candidateSession6.setCandidate(candidate2);

		candidateSession7.setSessionId(1007);
		candidateSession7.setSessionTopic("Data Engineer Screenig");
		candidateSession7.setCandidate(candidate);

		candidateSession8.setSessionId(1008);
		candidateSession8.setSessionTopic("Database Administrator Screenig");
		candidateSession8.setCandidate(candidate);

		candidateSession9.setSessionId(1009);
		candidateSession9.setSessionTopic("Java Screenig");
		candidateSession9.setCandidate(candidate);

		/* assigning sessions to candidates */

		candidate.setSessions(Arrays.asList(candidateSession, candidateSession9, candidateSession7, candidateSession8));
		candidate2.setSessions(Arrays.asList(candidateSession2, candidateSession6));
		candidate3.setSessions(Arrays.asList(candidateSession3, candidateSession4, candidateSession5));

		/* persisting the objects */

		session.save(candidate);
		session.save(candidate2);
		session.save(candidate3);
		session.save(candidateSession);
		session.save(candidateSession2);
		session.save(candidateSession3);
		session.save(candidateSession4);
		session.save(candidateSession5);
		session.save(candidateSession6);
		session.save(candidateSession7);
		session.save(candidateSession8);
		session.save(candidateSession9);

		transaction.commit();

		System.out.println();

		Candidate candidate4 = session.get(Candidate.class, 101);
		System.out.println(candidate4.getCandidateName() + "\n");
		candidate4.getSessions().forEach(new Consumer<CandidateSession>() {

			@Override
			public void accept(CandidateSession t) {
				// TODO Auto-generated method stub
				System.out.println(t.getSessionTopic());
			}

		});
	}

}
