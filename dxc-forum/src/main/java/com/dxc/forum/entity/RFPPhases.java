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
@Table(name="phase")
public class RFPPhases {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	@Column(name = "first")
    private String first;
    @Column(name = "second")
    private String second;
    @Column(name = "third")
    private String third;
    @Column(name = "fourth")
    private String fourth;
    @Column(name = "fifth")
    private String fifth;
    @Column(name = "sixth")
    private String sixth;
    @Column(name = "seventh")
    private String seventh;
    @Column(name = "eight")
    private String eighth;
    @Column(name = "ninth")
    private String ninth;
    @Column(name = "tenth")
    private String tenth;
    @Column(name = "eleven")
    private String eleven;
    @Column(name = "twelve")
    private String twelve;
    @Column(name = "thirteen")
    private String thirteen;
    @Column(name = "fourteen")
    private String fourteen;
    @Column(name = "fifteen")
    private String fifteen;
    @Column(name = "sixteen")
    private String sixteen;
    @Column(name = "seventeen")
    private String seventeen;
    @Column(name = "eighteen")
    private String eighteen;
	
	
	
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "rfp_id")
	private RFP rfp;



	public RFPPhases(Long id, String first, String second, String third, String fourth,
			String fifth, String sixth, String seventh, String eighth, String ninth,
			String tenth, String eleven, String twelve, String thirteen, String fourteen,
			String fifteen, String sixteen, String seventeen, String eighteen, RFP rfp) {
		super();
		this.id = id;
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		this.sixth = sixth;
		this.seventh = seventh;
		this.eighth = eighth;
		this.ninth = ninth;
		this.tenth = tenth;
		this.eleven = eleven;
		this.twelve = twelve;
		this.thirteen = thirteen;
		this.fourteen = fourteen;
		this.fifteen = fifteen;
		this.sixteen = sixteen;
		this.seventeen = seventeen;
		this.eighteen = eighteen;
		this.rfp = rfp;
	}



	public RFPPhases() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirst() {
		return first;
	}



	public void setFirst(String first) {
		this.first = first;
	}



	public String getSecond() {
		return second;
	}



	public void setSecond(String second) {
		this.second = second;
	}



	public String getThird() {
		return third;
	}



	public void setThird(String third) {
		this.third = third;
	}



	public String getFourth() {
		return fourth;
	}



	public void setFourth(String fourth) {
		this.fourth = fourth;
	}



	public String getFifth() {
		return fifth;
	}



	public void setFifth(String fifth) {
		this.fifth = fifth;
	}



	public String getSixth() {
		return sixth;
	}



	public void setSixth(String sixth) {
		this.sixth = sixth;
	}



	public String getSeventh() {
		return seventh;
	}



	public void setSeventh(String seventh) {
		this.seventh = seventh;
	}



	public String getEighth() {
		return eighth;
	}



	public void setEighth(String eighth) {
		this.eighth = eighth;
	}



	public String getNinth() {
		return ninth;
	}



	public void setNinth(String ninth) {
		this.ninth = ninth;
	}



	public String getTenth() {
		return tenth;
	}



	public void setTenth(String tenth) {
		this.tenth = tenth;
	}



	public String getEleven() {
		return eleven;
	}



	public void setEleven(String eleven) {
		this.eleven = eleven;
	}



	public String getTwelve() {
		return twelve;
	}



	public void setTwelve(String twelve) {
		this.twelve = twelve;
	}



	public String getThirteen() {
		return thirteen;
	}



	public void setThirteen(String thirteen) {
		this.thirteen = thirteen;
	}



	public String getFourteen() {
		return fourteen;
	}



	public void setFourteen(String fourteen) {
		this.fourteen = fourteen;
	}



	public String getFifteen() {
		return fifteen;
	}



	public void setFifteen(String fifteen) {
		this.fifteen = fifteen;
	}



	public String getSixteen() {
		return sixteen;
	}



	public void setSixteen(String sixteen) {
		this.sixteen = sixteen;
	}



	public String getSeventeen() {
		return seventeen;
	}



	public void setSeventeen(String seventeen) {
		this.seventeen = seventeen;
	}



	public String getEighteen() {
		return eighteen;
	}



	public void setEighteen(String eighteen) {
		this.eighteen = eighteen;
	}



	public RFP getRfp() {
		return rfp;
	}



	public void setRfp(RFP rfp) {
		this.rfp = rfp;
	}

	
	
	
}
