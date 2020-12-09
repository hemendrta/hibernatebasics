package com.map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	private int questionId;
	private String question;

	@OneToOne
	/*
	 * To specify that there is one to one mapping between for each question with
	 * answer
	 */
	@JoinColumn(name = "answer_id")
	/*
	 * This specifies the collumn of the foreign key and name is to change the name
	 */
	private Answer answer;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int questionId, String question, Answer answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", answer=" + answer + "]";
	}

}
