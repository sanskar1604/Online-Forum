package com.dxc.forum.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "answer")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ans_id")
	private Long id;
	@Column(name = "answer")
	private String answer;
	@CreationTimestamp
	@Column(name = "created_date")
    private Timestamp createdDate;
	
	//Many To One Mapping with Question Entity
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "ques_id")
//	@JsonIgnore
	private Question question;
	
	
	//Default Constructor
	public Answer() {
		super();
	}
	
	//Parameterized Constructor
	public Answer(Long id, String answer, Question question, Timestamp createdDate) {
		super();
		this.id = id;
		this.answer = answer;
		this.question = question;
		this.createdDate = createdDate;
	}
	
	// Getter and Setter Methods
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	

}
