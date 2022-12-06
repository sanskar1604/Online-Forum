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
@Table(name="rfp_web_services")
public class RFPWebServices {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "wsimpleDB")
	private String wsimpleDB;
	@Column(name = "wmediumDB")
	private String wmediumDB;
	@Column(name = "wcomplexDB")
	private String wcomplexDB;
	@Column(name = "wverycomplexDB")
	private String wveryComplexDB;
	@Column(name = "wsimplePI")
	private String wsimplePI;
	@Column(name = "wmediumPI")
	private String wmediumPI;
	@Column(name = "wcomplexPI")
	private String wcomplexPI;
	@Column(name = "wverycomplexPI")
	private String wveryComplexPI;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "rfp_id")
	private RFP rfp;

	public RFPWebServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RFPWebServices(Long id, String wsimpleDB, String wmediumDB, String wcomplexDB, String wveryComplexDB,
			String wsimplePI, String wmediumPI, String wcomplexPI, String wveryComplexPI, RFP rfp) {
		super();
		this.id = id;
		this.wsimpleDB = wsimpleDB;
		this.wmediumDB = wmediumDB;
		this.wcomplexDB = wcomplexDB;
		this.wveryComplexDB = wveryComplexDB;
		this.wsimplePI = wsimplePI;
		this.wmediumPI = wmediumPI;
		this.wcomplexPI = wcomplexPI;
		this.wveryComplexPI = wveryComplexPI;
		this.rfp = rfp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWsimpleDB() {
		return wsimpleDB;
	}

	public void setWsimpleDB(String wsimpleDB) {
		this.wsimpleDB = wsimpleDB;
	}

	public String getWmediumDB() {
		return wmediumDB;
	}

	public void setWmediumDB(String wmediumDB) {
		this.wmediumDB = wmediumDB;
	}

	public String getWcomplexDB() {
		return wcomplexDB;
	}

	public void setWcomplexDB(String wcomplexDB) {
		this.wcomplexDB = wcomplexDB;
	}

	public String getWveryComplexDB() {
		return wveryComplexDB;
	}

	public void setWveryComplexDB(String wveryComplexDB) {
		this.wveryComplexDB = wveryComplexDB;
	}

	public String getWsimplePI() {
		return wsimplePI;
	}

	public void setWsimplePI(String wsimplePI) {
		this.wsimplePI = wsimplePI;
	}

	public String getWmediumPI() {
		return wmediumPI;
	}

	public void setWmediumPI(String wmediumPI) {
		this.wmediumPI = wmediumPI;
	}

	public String getWcomplexPI() {
		return wcomplexPI;
	}

	public void setWcomplexPI(String wcomplexPI) {
		this.wcomplexPI = wcomplexPI;
	}

	public String getWveryComplexPI() {
		return wveryComplexPI;
	}

	public void setWveryComplexPI(String wveryComplexPI) {
		this.wveryComplexPI = wveryComplexPI;
	}

	public RFP getRfp() {
		return rfp;
	}

	public void setRfp(RFP rfp) {
		this.rfp = rfp;
	}

	
	
	
	
	
}
