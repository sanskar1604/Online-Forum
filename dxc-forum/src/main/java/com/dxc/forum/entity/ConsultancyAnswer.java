package com.dxc.forum.entity;

import java.beans.Transient;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "consultancyanswer")
public class ConsultancyAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ans_id")
	private Long id;
	@Column(name = "answer", columnDefinition="TEXT")
	private String answer;
	@CreationTimestamp
	@Column(name = "created_date")
    private Timestamp createdDate;
	
	//Many To One Mapping with Question Entity
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	@Transient
	@JoinColumn(name = "ques_id")
//	@JsonIgnore
	private ConsultancyQuestion question;
	
	
	//Default Constructor
	public ConsultancyAnswer() {
		super();
	}


	public ConsultancyAnswer(Long id, String answer, Timestamp createdDate, ConsultancyQuestion question) {
		super();
		this.id = id;
		this.answer = answer;
		this.createdDate = createdDate;
		this.question = question;
	}


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


	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	public ConsultancyQuestion getQuestion() {
		return question;
	}


	public void setQuestion(ConsultancyQuestion question) {
		this.question = question;
	}

	
}
