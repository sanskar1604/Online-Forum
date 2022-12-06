package com.dxc.forum.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name="rfp_springboot")
public class RFPSpringboot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "simpleDB")
	private String simpleDB;
	@Column(name = "mediumDB")
	private String mediumDB;
	@Column(name = "complexDB")
	private String complexDB;
	@Column(name = "verycomplexDB")
	private String veryComplexDB;
	@Column(name = "simplePI")
	private String simplePI;
	@Column(name = "mediumPI")
	private String mediumPI;
	@Column(name = "complexPI")
	private String complexPI;
	@Column(name = "verycomplexPI")
	private String veryComplexPI;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "rfp_id")
	private RFP rfp;

	public RFPSpringboot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RFPSpringboot(Long id, String simpleDB, String mediumDB, String complexDB, String veryComplexDB,
			String simplePI, String mediumPI, String complexPI, String veryComplexPI, RFP rfp) {
		super();
		this.id = id;
		this.simpleDB = simpleDB;
		this.mediumDB = mediumDB;
		this.complexDB = complexDB;
		this.veryComplexDB = veryComplexDB;
		this.simplePI = simplePI;
		this.mediumPI = mediumPI;
		this.complexPI = complexPI;
		this.veryComplexPI = veryComplexPI;
		this.rfp = rfp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSimpleDB() {
		return simpleDB;
	}

	public void setSimpleDB(String simpleDB) {
		this.simpleDB = simpleDB;
	}

	public String getMediumDB() {
		return mediumDB;
	}

	public void setMediumDB(String mediumDB) {
		this.mediumDB = mediumDB;
	}

	public String getComplexDB() {
		return complexDB;
	}

	public void setComplexDB(String complexDB) {
		this.complexDB = complexDB;
	}

	public String getVeryComplexDB() {
		return veryComplexDB;
	}

	public void setVeryComplexDB(String veryComplexDB) {
		this.veryComplexDB = veryComplexDB;
	}

	public String getSimplePI() {
		return simplePI;
	}

	public void setSimplePI(String simplePI) {
		this.simplePI = simplePI;
	}

	public String getMediumPI() {
		return mediumPI;
	}

	public void setMediumPI(String mediumPI) {
		this.mediumPI = mediumPI;
	}

	public String getComplexPI() {
		return complexPI;
	}

	public void setComplexPI(String complexPI) {
		this.complexPI = complexPI;
	}

	public String getVeryComplexPI() {
		return veryComplexPI;
	}

	public void setVeryComplexPI(String veryComplexPI) {
		this.veryComplexPI = veryComplexPI;
	}

	public RFP getRfp() {
		return rfp;
	}

	public void setRfp(RFP rfp) {
		this.rfp = rfp;
	}
	
	
	
	
	
	
}
