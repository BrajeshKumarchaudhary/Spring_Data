package com.app.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	
	private String question;
	
//	@OneToOne
	@OneToMany(mappedBy = "question")
    private List<Answer> ansId;
	
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", ansId=" + ansId + "]";
	}

	public Question() {
		super();
	}

	public Question(int questionId, String question, Answer ansId) {
		super();
		this.questionId = questionId;
		this.question = question;
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

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnsId() {
		return ansId;
	}

	public void setAnsId(List<Answer> ansId) {
		this.ansId = ansId;
	}

//	public Answer getAnsId() {
//		return ansId;
//	}
//
//	public void setAnsId(Answer ansId) {
//		this.ansId = ansId;
//	}
	
	
	
}
