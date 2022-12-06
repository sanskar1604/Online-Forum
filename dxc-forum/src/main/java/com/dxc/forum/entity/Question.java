package com.dxc.forum.entity;



import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ques_id")
	private Long id;
	@Column(name = "question_title")
	private String title;
	@Column(name = "question_body")
	private String body;
	@CreationTimestamp
	@Column(name = "created_date")
    private Timestamp createdDate;
	
	//One To Many Mapping with Answer Entity
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnore
	private List<Answer> answer =  new ArrayList<>();
	
	//Default Constructor
	public Question() {
		super();
	}
	
	//Parameterized Constructor
	public Question(Long id, String title, String body, Timestamp createdDate, List<Answer> answer) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.createdDate = createdDate;
		this.answer = answer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
	
	
	
	
}
