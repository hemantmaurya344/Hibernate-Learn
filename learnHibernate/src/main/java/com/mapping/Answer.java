package com.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Answer {
	@Id
	private int answer_id;
	private String Answer;
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public Answer() {
		super();
	}
	public Answer(int answer_id, String answer) {
		super();
		this.answer_id = answer_id;
		Answer = answer;
	}
	
	
}
