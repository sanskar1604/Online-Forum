package com.dxc.forum.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RFP_Tracker")
public class RFP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rfp_id")
	private Long id;
	@Column(name = "RFP_Title")
	private String rfpTitle;
	@Column(name = "Client")
	private String client;
	@Column(name = "Status")
	private String status;
	@Column(name = "Region")
	private String region;
	@Column(name = "Technology")
	private String technology;
	@Column(name = "Java_Capability_RFP_Team")
	private String javaCapabilityRfpTeam;
	@Column(name = "DXC_Solutioning_Lead")
	private String dxcSolutioningLead;
	@Column(name = "Type")
	private String type;
	@Column(name = "Notes", columnDefinition="TEXT")
	private String notes;
	@Column(name = "Total_Deal_Value")
	private String totalDealValue;
	@Column(name = "OPX_ID")
	private String opxId;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "Data_Of_Entry")
	private Date dateOfEntry;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ETA_To_Submit_RFP")
	private Date etaToSubmitRfp;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "Realization_Date")
	private Date realizationDate;
	@Column(name = "TCV_USD")
	private String tcvUsd;
	@Column(name = "Effort")
	private String effort;
	@Column(name = "Project_Planned_Status")
	private String projectPlannedStatus;
	
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "phases")
//	@JsonIgnore
//	private RFPPhases phases;
	
	public RFP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RFP(Long id, String rfpTitle, String client, String status, String region, String technology,
			String javaCapabilityRfpTeam, String dxcSolutioningLead, String type, String notes, String totalDealValue,
			String opxId, Date dateOfEntry, Date etaToSubmitRfp, Date realizationDate, String tcvUsd,
			String effort, String projectPlannedStatus, RFPPhases phases) {
		super();
		this.id = id;
		this.rfpTitle = rfpTitle;
		this.client = client;
		this.status = status;
		this.region = region;
		this.technology = technology;
		this.javaCapabilityRfpTeam = javaCapabilityRfpTeam;
		this.dxcSolutioningLead = dxcSolutioningLead;
		this.type = type;
		this.notes = notes;
		this.totalDealValue = totalDealValue;
		this.opxId = opxId;
		this.dateOfEntry = dateOfEntry;
		this.etaToSubmitRfp = etaToSubmitRfp;
		this.realizationDate = realizationDate;
		this.tcvUsd = tcvUsd;
		this.effort = effort;
		this.projectPlannedStatus = projectPlannedStatus;
//		this.phases = phases;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRfpTitle() {
		return rfpTitle;
	}

	public void setRfpTitle(String rfpTitle) {
		this.rfpTitle = rfpTitle;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getJavaCapabilityRfpTeam() {
		return javaCapabilityRfpTeam;
	}

	public void setJavaCapabilityRfpTeam(String javaCapabilityRfpTeam) {
		this.javaCapabilityRfpTeam = javaCapabilityRfpTeam;
	}

	public String getDxcSolutioningLead() {
		return dxcSolutioningLead;
	}

	public void setDxcSolutioningLead(String dxcSolutioningLead) {
		this.dxcSolutioningLead = dxcSolutioningLead;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getTotalDealValue() {
		return totalDealValue;
	}

	public void setTotalDealValue(String totalDealValue) {
		this.totalDealValue = totalDealValue;
	}

	public String getOpxId() {
		return opxId;
	}

	public void setOpxId(String opxId) {
		this.opxId = opxId;
	}

	public Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public Date getEtaToSubmitRfp() {
		return etaToSubmitRfp;
	}

	public void setEtaToSubmitRfp(Date etaToSubmitRfp) {
		this.etaToSubmitRfp = etaToSubmitRfp;
	}

	public Date getRealizationDate() {
		return realizationDate;
	}

	public void setRealizationDate(Date realizationDate) {
		this.realizationDate = realizationDate;
	}

	public String getTcvUsd() {
		return tcvUsd;
	}

	public void setTcvUsd(String tcvUsd) {
		this.tcvUsd = tcvUsd;
	}

	public String getEffort() {
		return effort;
	}

	public void setEffort(String effort) {
		this.effort = effort;
	}

	public String getProjectPlannedStatus() {
		return projectPlannedStatus;
	}

	public void setProjectPlannedStatus(String projectPlannedStatus) {
		this.projectPlannedStatus = projectPlannedStatus;
	}

//	public RFPPhases getPhases() {
//		return phases;
//	}
//
//	public void setPhases(RFPPhases phases) {
//		this.phases = phases;
//	}
	
	
	
	
}
