package com.hibernate.dataloading;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CandidateSession {

	@Id
	private int sessionId;
	private String sessionTopic;

	@ManyToOne
	private Candidate candidate;

	public CandidateSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CandidateSession(int sessionId, String sessionTopic, Candidate candidate) {
		super();
		this.sessionId = sessionId;
		this.sessionTopic = sessionTopic;
		this.candidate = candidate;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionTopic() {
		return sessionTopic;
	}

	public void setSessionTopic(String sessionTopic) {
		this.sessionTopic = sessionTopic;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "CandidateSession [sessionId=" + sessionId + ", sessionTopic=" + sessionTopic + ", candidate="
				+ candidate + "]";
	}

}
