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
@Table(name="rfp_jsp")
public class RFPJSP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "jsimpleDB")
	private String jsimpleDB;
	@Column(name = "jmediumDB")
	private String jmediumDB;
	@Column(name = "jcomplexDB")
	private String jcomplexDB;
	@Column(name = "jverycomplexDB")
	private String jveryComplexDB;
	@Column(name = "jsimplePI")
	private String jsimplePI;
	@Column(name = "jmediumPI")
	private String jmediumPI;
	@Column(name = "jcomplexPI")
	private String jcomplexPI;
	@Column(name = "jverycomplexPI")
	private String jveryComplexPI;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "rfp_id")
	private RFP rfp;

	public RFPJSP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RFPJSP(Long id, String jsimpleDB, String jmediumDB, String jcomplexDB, String jveryComplexDB,
			String jsimplePI, String jmediumPI, String jcomplexPI, String jveryComplexPI, RFP rfp) {
		super();
		this.id = id;
		this.jsimpleDB = jsimpleDB;
		this.jmediumDB = jmediumDB;
		this.jcomplexDB = jcomplexDB;
		this.jveryComplexDB = jveryComplexDB;
		this.jsimplePI = jsimplePI;
		this.jmediumPI = jmediumPI;
		this.jcomplexPI = jcomplexPI;
		this.jveryComplexPI = jveryComplexPI;
		this.rfp = rfp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJsimpleDB() {
		return jsimpleDB;
	}

	public void setJsimpleDB(String jsimpleDB) {
		this.jsimpleDB = jsimpleDB;
	}

	public String getJmediumDB() {
		return jmediumDB;
	}

	public void setJmediumDB(String jmediumDB) {
		this.jmediumDB = jmediumDB;
	}

	public String getJcomplexDB() {
		return jcomplexDB;
	}

	public void setJcomplexDB(String jcomplexDB) {
		this.jcomplexDB = jcomplexDB;
	}

	public String getJveryComplexDB() {
		return jveryComplexDB;
	}

	public void setJveryComplexDB(String jveryComplexDB) {
		this.jveryComplexDB = jveryComplexDB;
	}

	public String getJsimplePI() {
		return jsimplePI;
	}

	public void setJsimplePI(String jsimplePI) {
		this.jsimplePI = jsimplePI;
	}

	public String getJmediumPI() {
		return jmediumPI;
	}

	public void setJmediumPI(String jmediumPI) {
		this.jmediumPI = jmediumPI;
	}

	public String getJcomplexPI() {
		return jcomplexPI;
	}

	public void setJcomplexPI(String jcomplexPI) {
		this.jcomplexPI = jcomplexPI;
	}

	public String getJveryComplexPI() {
		return jveryComplexPI;
	}

	public void setJveryComplexPI(String jveryComplexPI) {
		this.jveryComplexPI = jveryComplexPI;
	}

	public RFP getRfp() {
		return rfp;
	}

	public void setRfp(RFP rfp) {
		this.rfp = rfp;
	}

	
	
	
	
}
