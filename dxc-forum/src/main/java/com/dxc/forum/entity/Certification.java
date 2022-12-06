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
@Table(name = "certificates", schema = "dxc_forum")
public class Certification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "emp_id", unique=true)
	private int empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_email", unique=true)
	private String empEmail;
	@Column(name = "exam_voucher", unique=true)
	private String voucher;
	@Column(name = "exam_status", nullable = true)
	private String status;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "exam_Date", nullable = false)
	private Date date;
	@Column(name = "remarks", nullable = false)
	private String remarks;
	
	public Certification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certification(Long id, int empId, String empName, String empEmail, String voucher, String status,
			Date date, String remarks) {
		super();
		this.id = id;
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.voucher = voucher;
		this.status = status;
		this.date = date;
		this.remarks = remarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

}
