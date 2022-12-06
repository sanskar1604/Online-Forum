package com.dxc.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="session")
public class UploadSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "session_id")
	private Long id;
	@Column(name = "batch")
	private String batch;
	@Column(name = "topic_name")
	private String topicName;
	@Column(name = "trainer_name")
	private String trainerName;
	@Column(name = "batch_size")
	private int batchSize;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "session_date")
	private Date sessionDate;
	@Column(name = "session_link")
	private String sessionLink;
	@Column(name = "session_video")
	private String sessionVideo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public int getBatchSize() {
		return this.batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	public Date getSessionDate() {
		return sessionDate;
	}
	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}
	public String getSessionLink() {
		return sessionLink;
	}
	public void setSessionLink(String sessionLink) {
		this.sessionLink = sessionLink;
	}
	public String getSessionVideo() {
		return sessionVideo;
	}
	public void setSessionVideo(String sessionVideo) {
		this.sessionVideo = sessionVideo;
	}
	
	//Default constructor
	public UploadSession() {
		super();
	}
	
	//Parameterized Constructor
	public UploadSession(Long id, String batch, String topicName, String trainerName, int batchSize,Date sessionDate,
			String sessionLink, String sessionVideo) {
		super();
		this.id = id;
		this.batch = batch;
		this.topicName = topicName;
		this.trainerName = trainerName;
		this.batchSize = batchSize;
		this.sessionDate = sessionDate;
		this.sessionLink = sessionLink;
		this.sessionVideo = sessionVideo;
	}
		
	
}
	
	
	

