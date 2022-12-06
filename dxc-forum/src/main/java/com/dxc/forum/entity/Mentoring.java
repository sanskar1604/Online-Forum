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
@Table(name = "mentoring")
public class Mentoring {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "decp_id")
	private Long id;
	@Column(name = "batch")
	private String batch;
	@Column(name = "emp_id", unique=true)
	private int empId;
	@Column(name = "emp_name")
	private String name;
	@Column(name = "emp_email", unique=true)
	private String email;
	@Column(name = "he_score")
	private int heScore;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "update_date")
	private Date updateDate;
	@Column(name = "he_rank")
	private int heRank;
	@Column(name = "project")
	private String project;
	@Column(name = "project_title")
	private String projectTitle;
	@Column(name = "tech_stack")
	private String techStack;
	@Column(name = "project_status")
	private String projectStatus;
	
	//Default Constructor
	public Mentoring() {
		super();
	}

	//Parameterized Constructor
	public Mentoring(Long id, String batch, int empId, String name, String email, int heScore, Date updateDate, int heRank,
			String project, String projectTitle, String techStack, String projectStatus) {
		super();
		this.id = id;
		this.batch = batch;
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.heScore = heScore;
		this.updateDate = updateDate;
		this.heRank = heRank;
		this.project = project;
		this.projectTitle = projectTitle;
		this.techStack = techStack;
		this.projectStatus = projectStatus;
	}

	//Getter & Setter Methods
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

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getHeScore() {
		return heScore;
	}

	public void setHeScore(int heScore) {
		this.heScore = heScore;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getHeRank() {
		return heRank;
	}

	public void setHeRank(int heRank) {
		this.heRank = heRank;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getTechStack() {
		return techStack;
	}

	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	
	
}
