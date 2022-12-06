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
@Table(name="data")

public class DetailedData {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private Long id;
		@Column(name = "module")
		private String module;
		@Column(name = "requirement")
		private String requirement;
		@Column(name = "requirement_details", columnDefinition="TEXT")
		private String requirement_details;
		@Column(name = "units")
		private String units ;
		@Column(name = "complexity")
		private String complexity;
		@Column(name = "cut_estimation")
		private String cut_estimation;
		@Column(name = "assumptions", columnDefinition="TEXT")
		private String assumptions;
		@Column(name = "comments", columnDefinition="TEXT")
		private String comments;
		
		@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
		@JoinColumn(name = "rfp_id")
		private RFP rfp;

		public DetailedData() {
			super();
			// TODO Auto-generated constructor stub
		}

		public DetailedData(Long id, String module, String requirement, String requirement_details, String units,
				String complexity, String cut_estimation, String assumptions, String comments, RFP rfp) {
			super();
			this.id = id;
			this.module = module;
			this.requirement = requirement;
			this.requirement_details = requirement_details;
			this.units = units;
			this.complexity = complexity;
			this.cut_estimation = cut_estimation;
			this.assumptions = assumptions;
			this.comments = comments;
			this.rfp = rfp;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getModule() {
			return module;
		}

		public void setModule(String module) {
			this.module = module;
		}

		public String getRequirement() {
			return requirement;
		}

		public void setRequirement(String requirement) {
			this.requirement = requirement;
		}

		public String getRequirement_details() {
			return requirement_details;
		}

		public void setRequirement_details(String requirement_details) {
			this.requirement_details = requirement_details;
		}

		public String getUnits() {
			return units;
		}

		public void setUnits(String units) {
			this.units = units;
		}

		public String getComplexity() {
			return complexity;
		}

		public void setComplexity(String complexity) {
			this.complexity = complexity;
		}

		public String getCut_estimation() {
			return cut_estimation;
		}

		public void setCut_estimation(String cut_estimation) {
			this.cut_estimation = cut_estimation;
		}

		public String getAssumptions() {
			return assumptions;
		}

		public void setAssumptions(String assumptions) {
			this.assumptions = assumptions;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public RFP getRfp() {
			return rfp;
		}

		public void setRfp(RFP rfp) {
			this.rfp = rfp;
		}
		
		
		
		

}
