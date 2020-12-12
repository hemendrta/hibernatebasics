package com.hibernate.dataloading;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Candidate {

	@Id
	private int candidateId;
	private String candidateName;

	@OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER) /* by default the fetch type is lazy */
	private List<CandidateSession> candidateSessions;

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(int candidateId, String candidateName, List<CandidateSession> candidateSessions) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidateSessions = candidateSessions;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public List<CandidateSession> getSessions() {
		return candidateSessions;
	}

	public void setSessions(List<CandidateSession> candidateSessions) {
		this.candidateSessions = candidateSessions;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", candidateSessions="
				+ candidateSessions + "]";
	}

}
