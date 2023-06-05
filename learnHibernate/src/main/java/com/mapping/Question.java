package com.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Question {
	@Id
	private int question_id;
	private String Question;
	@OneToOne
	Answer answer;
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public Question(int question_id, String question, Answer answer) {
		super();
		this.question_id = question_id;
		Question = question;
		this.answer = answer;
	}
	public Question() {
		super();
	}
	
	
}
